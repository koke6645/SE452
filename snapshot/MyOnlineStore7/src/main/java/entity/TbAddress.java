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
@Table(name = "TB_ADDRESS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAddress.findAll", query = "SELECT t FROM TbAddress t"),
    @NamedQuery(name = "TbAddress.findByAddid", query = "SELECT t FROM TbAddress t WHERE t.addid = :addid"),
    @NamedQuery(name = "TbAddress.findByAddline1", query = "SELECT t FROM TbAddress t WHERE t.addline1 = :addline1"),
    @NamedQuery(name = "TbAddress.findByAddstate", query = "SELECT t FROM TbAddress t WHERE t.addstate = :addstate"),
    @NamedQuery(name = "TbAddress.findByAddzip", query = "SELECT t FROM TbAddress t WHERE t.addzip = :addzip")})
public class TbAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ADDID")
    private Integer addid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ADDLINE1")
    private String addline1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ADDSTATE")
    private String addstate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADDZIP")
    private int addzip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cusshipadd")
    private Collection<TbCustomer> tbCustomerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cusbilladd")
    private Collection<TbCustomer> tbCustomerCollection1;

    public TbAddress() {
    }

    public TbAddress(String addline1, String addstate, int addzip) {
        this.addline1 = addline1;
        this.addstate = addstate;
        this.addzip = addzip;
    }

    public Integer getAddid() {
        return addid;
    }

    public String getAddline1() {
        return addline1;
    }

    public void setAddline1(String addline1) {
        this.addline1 = addline1;
    }

    public String getAddstate() {
        return addstate;
    }

    public void setAddstate(String addstate) {
        this.addstate = addstate;
    }

    public int getAddzip() {
        return addzip;
    }

    public void setAddzip(int addzip) {
        this.addzip = addzip;
    }

    @XmlTransient
    public Collection<TbCustomer> getTbCustomerCollection() {
        return tbCustomerCollection;
    }

    public void setTbCustomerCollection(Collection<TbCustomer> tbCustomerCollection) {
        this.tbCustomerCollection = tbCustomerCollection;
    }

    @XmlTransient
    public Collection<TbCustomer> getTbCustomerCollection1() {
        return tbCustomerCollection1;
    }

    public void setTbCustomerCollection1(Collection<TbCustomer> tbCustomerCollection1) {
        this.tbCustomerCollection1 = tbCustomerCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addid != null ? addid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAddress)) {
            return false;
        }
        TbAddress other = (TbAddress) object;
        if ((this.addid == null && other.addid != null) || (this.addid != null && !this.addid.equals(other.addid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbAddress[ addid=" + addid + " ]";
    }
    
}
