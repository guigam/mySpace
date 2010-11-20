/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entities.version;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.richfaces.component.UIDataTable;

/**
 *
 * @author guigamehdi
 */

public class GestionVersion {
    private version laversion = new version();
    private List<version> lesVersions = new LinkedList<version>();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager");
    private EntityManager em = emf.createEntityManager();
    private UIDataTable dataTable;

    /** Creates a new instance of GestionVersion */
    public GestionVersion() {
    }

    public List<version> listDesVersions(){
        Query query = getEm().createQuery("select v from version v");
        for(version v : (List<version>)query.getResultList()){
            getLesVersions().add(v);
        }
        return lesVersions;
    }


    public void derniereVersion() {
        Query query = em.createQuery("select v from version v ");
        lesVersions = query.getResultList();
        int nb = lesVersions.size();
        setLaversion(lesVersions.get(nb - 1));
        
    }
    /**
     * @return the lesVersions
     */
    public List<version> getLesVersions() {
        return lesVersions;
    }

    /**
     * @param lesVersions the lesVersions to set
     */
    public void setLesVersions(List<version> lesVersions) {
        this.lesVersions = lesVersions;
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
     * @return the laversion
     */
    public version getLaversion() {
        derniereVersion();
        return laversion;
    }

    /**
     * @param laversion the laversion to set
     */
    public void setLaversion(version laversion) {
        this.laversion = laversion;
    }

}
