/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entities.fichier;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.richfaces.component.UIDataTable;



/**
 *
 * @author guiga
 */

public class gestionFichier {
    private List<fichier> lesFichiers = new LinkedList<fichier>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager");
    private EntityManager em = emf.createEntityManager();
    private UIDataTable dataTable;
    private fichier monfichier = new fichier();
    private FileUploadBean gv = (FileUploadBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("fup");
 


    
    String format = "dd/MM/yy H:mm:ss";
    java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(format);
    java.util.Date madate = new java.util.Date();

    /** Creates a new instance of gestionFichier */
    public gestionFichier() {
    }

    
    
    
    public List<fichier> listDesFichiers(){
          Query query = em.createQuery("select f from fichier f ");
          lesFichiers = query.getResultList();
        return lesFichiers;

    }
    public String saveFichier() throws IOException{
        service.File monfile = gv.getFiles().get(0);
        String chemin = "/home/guiga/Bureau/mySpace/src/main/webapp/lesFichiers/";
        String nomComplet = "/mySpace/lesFichiers/" + monfile.getName();
        gv.paint(chemin, 0);

        monfichier.setChemin(nomComplet);
        monfichier.setDatefichier(madate);
        em.getTransaction().begin();
        em.persist(monfichier);
        em.getTransaction().commit();

        return "save";


        


    }

   public String saveFichierDev(String nomComplet , String desc, String nomFichier){
       monfichier.setNomFichier(nomFichier);
       monfichier.setDescription(desc);
       monfichier.setChemin(nomComplet);
       monfichier.setDatefichier(madate);
       em.getTransaction().begin();              
       em.persist(monfichier);
       em.getTransaction().commit();
          
     return "save";
   }//

   public String supprimeFichier(){
        monfichier = (fichier) dataTable.getRowData();
        em.getTransaction().begin();
        em.remove(monfichier);
        em.getTransaction().commit();


        return "save";
   }


    /**
     * @return the emf
     */
    public EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * @param emf the emf to set
     */
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the dataTable
     */
    public UIDataTable getDataTable() {
        return dataTable;
    }

    /**
     * @param dataTable the dataTable to set
     */
    public void setDataTable(UIDataTable dataTable) {
        this.dataTable = dataTable;
    }

    /**
     * @return the lesFichiers
     */
    public List<fichier> getLesFichiers() {
        return lesFichiers;
    }

    /**
     * @param lesFichiers the lesFichiers to set
     */
    public void setLesFichiers(List<fichier> lesFichiers) {
        this.lesFichiers = lesFichiers;
    }

    /**
     * @return the monfichier
     */
    public fichier getMonfichier() {
        return monfichier;
    }

    /**
     * @param monfichier the monfichier to set
     */
    public void setMonfichier(fichier monfichier) {
        this.monfichier = monfichier;
    }

    private Date SimpleDateFormat(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    

}
