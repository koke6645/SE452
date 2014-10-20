/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RedPencil
 */
@Entity
@Table(name = "TB_CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCustomer.findAll", query = "SELECT t FROM TbCustomer t"),
    @NamedQuery(name = "TbCustomer.findByCusid", query = "SELECT t FROM TbCustomer t WHERE t.cusid = :cusid"),
    @NamedQuery(name = "TbCustomer.findByCusassid", query = "SELECT t FROM TbCustomer t WHERE t.cusassid = :cusassid"),
    @NamedQuery(name = "TbCustomer.findByCuspass", query = "SELECT t FROM TbCustomer t WHERE t.cuspass = :cuspass"),
    @NamedQuery(name = "TbCustomer.findByCusfirst", query = "SELECT t FROM TbCustomer t WHERE t.cusfirst = :cusfirst"),
    @NamedQuery(name = "TbCustomer.findByCuslast", query = "SELECT t FROM TbCustomer t WHERE t.cuslast = :cuslast"),
    @NamedQuery(name = "TbCustomer.findByCusemail", query = "SELECT t FROM TbCustomer t WHERE t.cusemail = :cusemail"),
    @NamedQuery(name = "TbCustomer.findByCusphone", query = "SELECT t FROM TbCustomer t WHERE t.cusphone = :cusphone")})
public class TbCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CUSID")
    private Integer cusid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CUSASSID")
    private String cusassid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CUSPASS")
    private String cuspass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CUSFIRST")
    private String cusfirst;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CUSLAST")
    private String cuslast;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "CUSEMAIL")
    private String cusemail;
    @Column(name = "CUSPHONE")
    private Integer cusphone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cusid")
    private Collection<TbOrder> tbOrderCollection;
    @JoinColumn(name = "CUSSHIPADD", referencedColumnName = "ADDID")
    @ManyToOne(optional = false)
    private TbAddress cusshipadd;
    @JoinColumn(name = "CUSBILLADD", referencedColumnName = "ADDID")
    @ManyToOne(optional = false)
    private TbAddress cusbilladd;
    @JoinColumn(name = "CREDITID", referencedColumnName = "CREDITID")
    @ManyToOne(optional = false)
    private TbCreditCard creditid;

    public TbCustomer() {
    }

    public TbCustomer(Integer cusid) {
        this.cusid = cusid;
    }

    public TbCustomer(Integer cusid, String cusassid, String cuspass, String cusfirst, String cuslast, String cusemail) {
        this.cusid = cusid;
        this.cusassid = cusassid;
        this.cuspass = cuspass;
        this.cusfirst = cusfirst;
        this.cuslast = cuslast;
        this.cusemail = cusemail;
    }

    public Integer getCusid() {
        return cusid;
    }

    public void setCusid(Integer cusid) {
        this.cusid = cusid;
    }

    public String getCusassid() {
        return cusassid;
    }

    public void setCusassid(String cusassid) {
        this.cusassid = cusassid;
    }

    public String getCuspass() {
        return cuspass;
    }

    public void setCuspass(String cuspass) {
        this.cuspass = cuspass;
    }

    public String getCusfirst() {
        return cusfirst;
    }

    public void setCusfirst(String cusfirst) {
        this.cusfirst = cusfirst;
    }

    public String getCuslast() {
        return cuslast;
    }

    public void setCuslast(String cuslast) {
        this.cuslast = cuslast;
    }

    public String getCusemail() {
        return cusemail;
    }

    public void setCusemail(String cusemail) {
        this.cusemail = cusemail;
    }

    public Integer getCusphone() {
        return cusphone;
    }

    public void setCusphone(Integer cusphone) {
        this.cusphone = cusphone;
    }

    @XmlTransient
    public Collection<TbOrder> getTbOrderCollection() {
        return tbOrderCollection;
    }

    public void setTbOrderCollection(Collection<TbOrder> tbOrderCollection) {
        this.tbOrderCollection = tbOrderCollection;
    }

    public TbAddress getCusshipadd() {
        return cusshipadd;
    }

    public void setCusshipadd(TbAddress cusshipadd) {
        this.cusshipadd = cusshipadd;
    }

    public TbAddress getCusbilladd() {
        return cusbilladd;
    }

    public void setCusbilladd(TbAddress cusbilladd) {
        this.cusbilladd = cusbilladd;
    }

    public TbCreditCard getCreditid() {
        return creditid;
    }

    public void setCreditid(TbCreditCard creditid) {
        this.creditid = creditid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusid != null ? cusid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCustomer)) {
            return false;
        }
        TbCustomer other = (TbCustomer) object;
        if ((this.cusid == null && other.cusid != null) || (this.cusid != null && !this.cusid.equals(other.cusid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.TbCustomer[ cusid=" + cusid + " ]";
    }
    
}
