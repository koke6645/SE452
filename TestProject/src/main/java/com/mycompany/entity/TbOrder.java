package com.mycompany.entity;

import com.mycompany.entityInterface.Order;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "TB_ORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbOrder.findAll", query = "SELECT t FROM TbOrder t"),
    @NamedQuery(name = "TbOrder.findByOrderid", query = "SELECT t FROM TbOrder t WHERE t.orderid = :orderid"),
    @NamedQuery(name = "TbOrder.findByOrderdate", query = "SELECT t FROM TbOrder t WHERE t.orderdate = :orderdate")})
public class TbOrder implements Serializable, Order {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORDERID")
    private Integer orderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERDATE")
    private int orderdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderid")
    private Collection<TbOrderItem> tbOrderItemCollection;
    @JoinColumn(name = "CUSID", referencedColumnName = "CUSID")
    @ManyToOne(optional = false)
    private TbCustomer cusid;
    @JoinColumn(name = "ORDERSTATUS", referencedColumnName = "STATUSID")
    @ManyToOne(optional = false)
    private TbStatus orderstatus;

    public TbOrder() {
    }

    public TbOrder(Integer orderid) {
        this.orderid = orderid;
    }

    public TbOrder(Integer orderid, int orderdate) {
        this.orderid = orderid;
        this.orderdate = orderdate;
    }

    @Override
    public Integer getOrderid() {
        return orderid;
    }

    @Override
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    @Override
    public int getOrderdate() {
        return orderdate;
    }

    @Override
    public void setOrderdate(int orderdate) {
        this.orderdate = orderdate;
    }

    @XmlTransient
    @Override
    public Collection<TbOrderItem> getTbOrderItemCollection() {
        return tbOrderItemCollection;
    }

    @Override
    public void setTbOrderItemCollection(Collection<TbOrderItem> tbOrderItemCollection) {
        this.tbOrderItemCollection = tbOrderItemCollection;
    }

    @Override
    public TbCustomer getCusid() {
        return cusid;
    }

    @Override
    public void setCusid(TbCustomer cusid) {
        this.cusid = cusid;
    }

    @Override
    public TbStatus getOrderstatus() {
        return orderstatus;
    }

    @Override
    public void setOrderstatus(TbStatus orderstatus) {
        this.orderstatus = orderstatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbOrder)) {
            return false;
        }
        TbOrder other = (TbOrder) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.TbOrder[ orderid=" + orderid + " ]";
    }
    
}
