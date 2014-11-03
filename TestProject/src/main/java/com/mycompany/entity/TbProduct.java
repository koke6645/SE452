package com.mycompany.entity;

import com.mycompany.entity.Interface.Product;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "TB_PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProduct.findAll", query = "SELECT t FROM TbProduct t"),
    @NamedQuery(name = "TbProduct.findByProid", query = "SELECT t FROM TbProduct t WHERE t.proid = :proid"),
    @NamedQuery(name = "TbProduct.findByProname", query = "SELECT t FROM TbProduct t WHERE t.proname = :proname"),
    @NamedQuery(name = "TbProduct.findByProinfo", query = "SELECT t FROM TbProduct t WHERE t.proinfo = :proinfo"),
    @NamedQuery(name = "TbProduct.findByPrice", query = "SELECT t FROM TbProduct t WHERE t.price = :price")})
public class TbProduct implements Serializable, Product {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PROID")
    private Integer proid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "PRONAME")
    private String proname;
    @Size(max = 400)
    @Column(name = "PROINFO")
    private String proinfo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private double price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proid")
    private Collection<TbOrderItem> tbOrderItemCollection;
    @JoinColumn(name = "CATID", referencedColumnName = "CATID")
    @ManyToOne(optional = false)
    private TbCategory catid;
    @JoinColumn(name = "LASTUPDATE", referencedColumnName = "EMPID")
    @ManyToOne
    private TbEmployee lastupdate;
    @JoinColumn(name = "PROSTATUS", referencedColumnName = "STATUSID")
    @ManyToOne(optional = false)
    private TbStatus prostatus;

    public TbProduct() {
    }

    public TbProduct(Integer proid) {
        this.proid = proid;
    }

    public TbProduct(Integer proid, String proname, double price) {
        this.proid = proid;
        this.proname = proname;
        this.price = price;
    }

    @Override
    public Integer getProid() {
        return proid;
    }

    @Override
    public void setProid(Integer proid) {
        this.proid = proid;
    }

    @Override
    public String getProname() {
        return proname;
    }

    @Override
    public void setProname(String proname) {
        this.proname = proname;
    }

    @Override
    public String getProinfo() {
        return proinfo;
    }

    @Override
    public void setProinfo(String proinfo) {
        this.proinfo = proinfo;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<TbOrderItem> getTbOrderItemCollection() {
        return tbOrderItemCollection;
    }

    public void setTbOrderItemCollection(Collection<TbOrderItem> tbOrderItemCollection) {
        this.tbOrderItemCollection = tbOrderItemCollection;
    }

    @Override
    public TbCategory getCatid() {
        return catid;
    }

    @Override
    public void setCatid(TbCategory catid) {
        this.catid = catid;
    }

    @Override
    public TbEmployee getLastupdate() {
        return lastupdate;
    }

    @Override
    public void setLastupdate(TbEmployee lastupdate) {
        this.lastupdate = lastupdate;
    }

    @Override
    public TbStatus getProstatus() {
        return prostatus;
    }

    @Override
    public void setProstatus(TbStatus prostatus) {
        this.prostatus = prostatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proid != null ? proid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProduct)) {
            return false;
        }
        TbProduct other = (TbProduct) object;
        if ((this.proid == null && other.proid != null) || (this.proid != null && !this.proid.equals(other.proid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.TbProduct[ proid=" + proid + " ]";
    }
    
}
