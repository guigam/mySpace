/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import com.sun.facelets.FaceletContext;
import entities.user;
import javax.faces.context.FacesContext;
import javax.persistence.*;
import javax.servlet.http.HttpSession;


/**
 *
 * @author guigamehdi
 */
public class Login {
    private user monUser = new user();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager");
    private EntityManager em = emf.createEntityManager();

    /** Creates a new instance of Login */
    public Login() {
    }
    public String connexion(){
        Query query = getEm().createQuery("select u from user u where u.username = ?1 and u.password = ?2");
        query.setParameter(1, getMonUser().getUsername());
        query.setParameter(2, getMonUser().getPassword());
        if(query.getResultList().isEmpty()){
            return "nok";
        }
        monUser = (user) query.getResultList().get(0);

        return "conn";
    }

    public String logout(){
((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
         
        return "accueil";
    }

    /**
     * @return the monUser
     */
    public user getMonUser() {
        return monUser;
    }

    /**
     * @param monUser the monUser to set
     */
    public void setMonUser(user monUser) {
        this.monUser = monUser;
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

}
