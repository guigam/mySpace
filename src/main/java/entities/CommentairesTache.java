/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import entities.taches;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author guiga
 */
@Entity
@Table(name = "commentairesTache", catalog = "space", schema = "")
@NamedQueries({
    @NamedQuery(name = "CommentairesTache.findAll", query = "SELECT c FROM CommentairesTache c"),
    @NamedQuery(name = "CommentairesTache.findById", query = "SELECT c FROM CommentairesTache c WHERE c.id = :id"),
    @NamedQuery(name = "CommentairesTache.findByComments", query = "SELECT c FROM CommentairesTache c WHERE c.comments = :comments"),
    @NamedQuery(name = "CommentairesTache.findByDate", query = "SELECT c FROM CommentairesTache c WHERE c.date = :date"),
    @NamedQuery(name = "CommentairesTache.findByLeUserid", query = "SELECT c FROM CommentairesTache c WHERE c.leUserid = :leUserid"),
    @NamedQuery(name = "CommentairesTache.findByMatacheId", query = "SELECT c FROM CommentairesTache c WHERE c.matacheId = :matacheId")})
public class CommentairesTache implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "comments", length = 255)
    private String comments;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "leUser_id")
    private BigInteger leUserid;
    @Column(name = "matache_id")
    private BigInteger matacheId;
    @ManyToOne
    private taches tache;
    public CommentairesTache() {
    }

    public CommentairesTache(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigInteger getLeUserid() {
        return leUserid;
    }

    public void setLeUserid(BigInteger leUserid) {
        this.leUserid = leUserid;
    }

    public BigInteger getMatacheId() {
        return matacheId;
    }

    public void setMatacheId(BigInteger matacheId) {
        this.matacheId = matacheId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentairesTache)) {
            return false;
        }
        CommentairesTache other = (CommentairesTache) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "service.CommentairesTache[id=" + id + "]";
    }

    /**
     * @return the tache
     */
    public taches getTache() {
        return tache;
    }

    /**
     * @param tache the tache to set
     */
    public void setTache(taches tache) {
        this.tache = tache;
    }
    

}
