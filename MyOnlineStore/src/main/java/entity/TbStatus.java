/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RedPencil
 */
@Entity
@Table(name = "TB_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbStatus.findAll", query = "SELECT t FROM TbStatus t"),
    @NamedQuery(name = "TbStatus.findByStatusid", query = "SELECT t FROM TbStatus t WHERE t.statusid = :statusid"),
    @NamedQuery(name = "TbStatus.findByStatusstate", query = "SELECT t FROM TbStatus t WHERE t.statusstate = :statusstate")})
public class TbStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "STATUSID")
    private Integer statusid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "STATUSSTATE")
    private String statusstate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderstatus")
    private Collection<TbOrder> tbOrderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prostatus")
    private Collection<TbProduct> tbProductCollection;

    public TbStatus() {
    }

    public TbStatus(Integer statusid) {
        this.statusid = statusid;
    }

    public TbStatus(Integer statusid, String statusstate) {
        this.statusid = statusid;
        this.statusstate = statusstate;
    }

    public Integer getStatusid() {
        return statusid;
    }

    public void setStatusid(Integer statusid) {
        this.statusid = statusid;
    }

    public String getStatusstate() {
        return statusstate;
    }

    public void setStatusstate(String statusstate) {
        this.statusstate = statusstate;
    }

    @XmlTransient
    public Collection<TbOrder> getTbOrderCollection() {
        return tbOrderCollection;
    }

    public void setTbOrderCollection(Collection<TbOrder> tbOrderCollection) {
        this.tbOrderCollection = tbOrderCollection;
    }

    @XmlTransient
    public Collection<TbProduct> getTbProductCollection() {
        return tbProductCollection;
    }

    public void setTbProductCollection(Collection<TbProduct> tbProductCollection) {
        this.tbProductCollection = tbProductCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusid != null ? statusid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbStatus)) {
            return false;
        }
        TbStatus other = (TbStatus) object;
        if ((this.statusid == null && other.statusid != null) || (this.statusid != null && !this.statusid.equals(other.statusid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbStatus[ statusid=" + statusid + " ]";
    }
    
}
