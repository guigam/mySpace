/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entities.CommentairesTache;
import entities.taches;
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
@ManagedBean(name="commenttache")
@RequestScoped
public class GestionCommentTache {
    private List<CommentairesTache> lesCommentaires = new LinkedList<CommentairesTache>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager");
    private EntityManager em = emf.createEntityManager();
  
    
    
   
    //GestionVersion gv = (GestionVersion)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("gestionVersion");
    
      // version laversion =  (version) gv.getDataTable().getRowData();
    /** Creates a new instance of GestionComment */
    public GestionCommentTache() {
    }

    

    public void  listDesCommentaires(taches tache){
    Query query = em.createQuery("select c from commentaires c where  c.matacheId = ?1");
        query.setParameter(1, tache);
        lesCommentaires =  query.getResultList();
        
    }



    /**
     * @return the lesCommentaires
     */
    public List<CommentairesTache> getLesCommentaires() {
    
        return lesCommentaires;
    }

    /**
     * @param lesCommentaires the lesCommentaires to set
     */
    public void setLesCommentaires(List<CommentairesTache> lesCommentaires) {
        this.lesCommentaires = lesCommentaires;
    }



}
