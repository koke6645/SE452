/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RedPencil
 */
@Entity
@Table(name = "TB_ORDER_ITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbOrderItem.findAll", query = "SELECT t FROM TbOrderItem t"),
    @NamedQuery(name = "TbOrderItem.findByOrderitemid", query = "SELECT t FROM TbOrderItem t WHERE t.orderitemid = :orderitemid"),
    @NamedQuery(name = "TbOrderItem.findByPrice", query = "SELECT t FROM TbOrderItem t WHERE t.price = :price"),
    @NamedQuery(name = "TbOrderItem.findByQty", query = "SELECT t FROM TbOrderItem t WHERE t.qty = :qty")})
public class TbOrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORDERITEMID")
    private Integer orderitemid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTY")
    private int qty;
    @JoinColumn(name = "ORDERID", referencedColumnName = "ORDERID")
    @ManyToOne(optional = false)
    private TbOrder orderid;
    @JoinColumn(name = "PROID", referencedColumnName = "PROID")
    @ManyToOne(optional = false)
    private TbProduct proid;

    public TbOrderItem() {
    }

    public TbOrderItem(Integer orderitemid) {
        this.orderitemid = orderitemid;
    }

    public TbOrderItem(Integer orderitemid, double price, int qty) {
        this.orderitemid = orderitemid;
        this.price = price;
        this.qty = qty;
    }

    public Integer getOrderitemid() {
        return orderitemid;
    }

    public void setOrderitemid(Integer orderitemid) {
        this.orderitemid = orderitemid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public TbOrder getOrderid() {
        return orderid;
    }

    public void setOrderid(TbOrder orderid) {
        this.orderid = orderid;
    }

    public TbProduct getProid() {
        return proid;
    }

    public void setProid(TbProduct proid) {
        this.proid = proid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderitemid != null ? orderitemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbOrderItem)) {
            return false;
        }
        TbOrderItem other = (TbOrderItem) object;
        if ((this.orderitemid == null && other.orderitemid != null) || (this.orderitemid != null && !this.orderitemid.equals(other.orderitemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.TbOrderItem[ orderitemid=" + orderitemid + " ]";
    }
    
}
