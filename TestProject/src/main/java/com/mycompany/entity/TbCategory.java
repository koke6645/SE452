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
@Table(name = "TB_CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCategory.findAll", query = "SELECT t FROM TbCategory t"),
    @NamedQuery(name = "TbCategory.findByCatid", query = "SELECT t FROM TbCategory t WHERE t.catid = :catid"),
    @NamedQuery(name = "TbCategory.findByCatname", query = "SELECT t FROM TbCategory t WHERE t.catname = :catname")})
public class TbCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CATID")
    private Integer catid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CATNAME")
    private String catname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catid")
    private Collection<TbProduct> tbProductCollection;

    public TbCategory() {
    }

    public TbCategory(Integer catid) {
        this.catid = catid;
    }

    public TbCategory(Integer catid, String catname) {
        this.catid = catid;
        this.catname = catname;
    }

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
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
        hash += (catid != null ? catid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCategory)) {
            return false;
        }
        TbCategory other = (TbCategory) object;
        if ((this.catid == null && other.catid != null) || (this.catid != null && !this.catid.equals(other.catid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.TbCategory[ catid=" + catid + " ]";
    }
    
}
