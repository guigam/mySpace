/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entities.CommentairesTache;
import entities.taches;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.faces.event.ValueChangeEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.richfaces.component.UIDataTable;

/**
 *
 * @author guiga
 */

public class gestionTache {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager");
    private EntityManager em = emf.createEntityManager();
    private List<taches> mesTaches = new LinkedList<taches>();
    private List<CommentairesTache> comTach = new LinkedList<CommentairesTache>();
    private taches matache = new taches();
    private String type = null;
  //  private developpement deev =  ((gestionDEv) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("dev")).getMonDev();
    
    
   // private developpement leDEv = ((gestionDEv) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("dev")).getMonDev();
    private UIDataTable dataTable;
    private taches tt = new taches();
    /** Creates a new instance of gestionTache */
    public gestionTache() {
    }

   
    public String getsaveTache(){
        SimpleDateFormat dd = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
        taches tach = new taches();
        tach.setDescription(getMatache().getDescription());
        tach.setEtat(false);
        tach.setNomTache(getMatache().getNomTache());
        tach.setMadate(new Date());

        //tach.setLeDev(deev);
        return "taches";
    }
    public String enregistrerTAches(){
        taches tach = new taches();
      
        matache.setEtat(false);
       
        matache.setMadate(new Date());
        em.getTransaction().begin();
        em.persist(matache);
        em.getTransaction().commit();

        //tach.setLeDev(deev);
        return "taches";
        
    }
    public void comboChange(ValueChangeEvent e){
    setType(e,getType());
    }

    public void filtertache(){
        if(type == null ? "Tous" == null : type.equals("Tous")){
            Query query = em.createQuery("from taches");
            mesTaches = query.getResultList();

        }else {
            if(type == "Terminé"){
                Query query = em.createQuery("from taches t where t.etat = 1");
                mesTaches = query.getResultList();
            }else{
                Query query = em.createQuery("from taches t where t.etat = 0");
                mesTaches = query.getResultList();

            }

        }

    }


    public String supprimerUneTache(){
        em.getTransaction().begin();
        matache = (taches) dataTable.getRowData();
        
        em.remove(matache);
        em.getTransaction().commit();
        
        return "taches";
    }
    public List<taches> getlistDesTaches(){
        Query query = em.createQuery("from taches");
        mesTaches = query.getResultList();
        
        return mesTaches;
    }
    public List<CommentairesTache> getcommentaireTache(){
        if (dataTable.getRowData() != null)
        matache = (taches) dataTable.getRowData();
       comTach =  new GestionCommentTache().listDesCommentaires(matache);
       return comTach;
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
     * @return the mesTaches
     */
    public List<taches> getMesTaches() {
        return mesTaches;
    }

    /**
     * @param mesTaches the mesTaches to set
     */
    public void setMesTaches(List<taches> mesTaches) {
        this.setMesTaches(mesTaches);
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
     * @return the tt
     */
    public taches getTt() {
        return tt;
    }

    /**
     * @param tt the tt to set
     */
    public void setTt(taches tt) {
        this.tt = tt;
    }

    /**
     * @return the matache
     */
    public taches getMatache() {
        return matache;
    }

    /**
     * @param matache the matache to set
     */
    public void setMatache(taches matache) {
        this.matache = matache;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    private void setType(ValueChangeEvent e, String type) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return the comTach
     */
    public List<CommentairesTache> getComTach() {
        return comTach;
    }

    /**
     * @param comTach the comTach to set
     */
    public void setComTach(List<CommentairesTache> comTach) {
        this.comTach = comTach;
    }

   
   
   

    

}
