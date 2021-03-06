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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RedPencil
 */
@Entity
@Table(name = "TB_CREDIT_CARD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCreditCard.findAll", query = "SELECT t FROM TbCreditCard t"),
    @NamedQuery(name = "TbCreditCard.findByCreditid", query = "SELECT t FROM TbCreditCard t WHERE t.creditid = :creditid"),
    @NamedQuery(name = "TbCreditCard.findByCardnumber", query = "SELECT t FROM TbCreditCard t WHERE t.cardnumber = :cardnumber"),
    @NamedQuery(name = "TbCreditCard.findByCardexpire", query = "SELECT t FROM TbCreditCard t WHERE t.cardexpire = :cardexpire")})
public class TbCreditCard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CREDITID")
    private Integer creditid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARDNUMBER")
    private int cardnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARDEXPIRE")
    private int cardexpire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditid")
    private Collection<TbCustomer> tbCustomerCollection;

    public TbCreditCard() {
    }

    public TbCreditCard(Integer creditid) {
        this.creditid = creditid;
    }

    public TbCreditCard(int cardnumber, int cardexpire) {
        this.cardnumber = cardnumber;
        this.cardexpire = cardexpire;
    }

    public Integer getCreditid() {
        return creditid;
    }

    public void setCreditid(Integer creditid) {
        this.creditid = creditid;
    }

    public int getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(int cardnumber) {
        this.cardnumber = cardnumber;
    }

    public int getCardexpire() {
        return cardexpire;
    }

    public void setCardexpire(int cardexpire) {
        this.cardexpire = cardexpire;
    }

    @XmlTransient
    public Collection<TbCustomer> getTbCustomerCollection() {
        return tbCustomerCollection;
    }

    public void setTbCustomerCollection(Collection<TbCustomer> tbCustomerCollection) {
        this.tbCustomerCollection = tbCustomerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditid != null ? creditid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCreditCard)) {
            return false;
        }
        TbCreditCard other = (TbCreditCard) object;
        if ((this.creditid == null && other.creditid != null) || (this.creditid != null && !this.creditid.equals(other.creditid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbCreditCard[ creditid=" + creditid + " ]";
    }
    
}
