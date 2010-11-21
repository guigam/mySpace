/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author guigamehdi
 */
@Entity
public class version implements Serializable {
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String laVersion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateVersion;
    private String Description;
    private String chemin;
    private String informations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof version)) {
            return false;
        }
        version other = (version) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.version[id=" + getId() + "]";
    }

    /**
     * @return the laVersion
     */
    public String getLaVersion() {
        return laVersion;
    }

    /**
     * @param laVersion the laVersion to set
     */
    public void setLaVersion(String laVersion) {
        this.laVersion = laVersion;
    }

    /**
     * @return the dateVersion
     */
    public Date getDateVersion() {
        return dateVersion;
    }

    /**
     * @param dateVersion the dateVersion to set
     */
    public void setDateVersion(Date dateVersion) {
        this.dateVersion = dateVersion;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the chemin
     */
    public String getChemin() {
        return chemin;
    }

    /**
     * @param chemin the chemin to set
     */
    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    /**
     * @return the informations
     */
    public String getInformations() {
        return informations;
    }

    /**
     * @param informations the informations to set
     */
    public void setInformations(String informations) {
        this.informations = informations;
    }

}
