/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entities.commentaires;
import entities.user;
import entities.version;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import service.GestionVersion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.richfaces.component.UIDataTable;

/**
 *
 * @author guiga
 */
@ManagedBean(name="comment")
@RequestScoped
public class GestionComment {
    private List<commentaires> lesCommentaires = new LinkedList<commentaires>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager");
    private EntityManager em = emf.createEntityManager();
  
    
    
   
    //GestionVersion gv = (GestionVersion)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("gestionVersion");
    
      // version laversion =  (version) gv.getDataTable().getRowData();
    /** Creates a new instance of GestionComment */
    public GestionComment() {
    }

    

    public List<commentaires> listDesCommentaires(){
    Query query = em.createQuery("select c from commentaires c where  c.laVersion = ?1");

//    query.setParameter(1, laversion);

        setLesCommentaires((List<commentaires>) query.getResultList());


        return getLesCommentaires();
    }



    /**
     * @return the lesCommentaires
     */
    public List<commentaires> getLesCommentaires() {
        return lesCommentaires;
    }

    /**
     * @param lesCommentaires the lesCommentaires to set
     */
    public void setLesCommentaires(List<commentaires> lesCommentaires) {
        this.lesCommentaires = lesCommentaires;
    }



}
