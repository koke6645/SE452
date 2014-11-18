/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "TB_EMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEmployee.findAll", query = "SELECT t FROM TbEmployee t"),
    @NamedQuery(name = "TbEmployee.findByEmpid", query = "SELECT t FROM TbEmployee t WHERE t.empid = :empid"),
    @NamedQuery(name = "TbEmployee.findByEmpassid", query = "SELECT t FROM TbEmployee t WHERE t.empassid = :empassid"),
    @NamedQuery(name = "TbEmployee.findByEmppass", query = "SELECT t FROM TbEmployee t WHERE t.emppass = :emppass"),
    @NamedQuery(name = "TbEmployee.findByEmpfirst", query = "SELECT t FROM TbEmployee t WHERE t.empfirst = :empfirst"),
    @NamedQuery(name = "TbEmployee.findByEmplast", query = "SELECT t FROM TbEmployee t WHERE t.emplast = :emplast"),
    @NamedQuery(name = "TbEmployee.findByEmpemail", query = "SELECT t FROM TbEmployee t WHERE t.empemail = :empemail"),
    @NamedQuery(name = "TbEmployee.findByEmpphone", query = "SELECT t FROM TbEmployee t WHERE t.empphone = :empphone")})
public class TbEmployee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EMPID")
    private Integer empid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMPASSID")
    private String empassid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMPPASS")
    private String emppass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMPFIRST")
    private String empfirst;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMPLAST")
    private String emplast;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "EMPEMAIL")
    private String empemail;
    @Column(name = "EMPPHONE")
    private Integer empphone;
    @OneToMany(mappedBy = "lastupdate")
    private Collection<TbProduct> tbProductCollection;

    public TbEmployee() {
    }

    public TbEmployee(Integer empid) {
        this.empid = empid;
    }

    public TbEmployee(Integer empid, String empassid, String emppass, String empfirst, String emplast, String empemail) {
        this.empid = empid;
        this.empassid = empassid;
        this.emppass = emppass;
        this.empfirst = empfirst;
        this.emplast = emplast;
        this.empemail = empemail;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpassid() {
        return empassid;
    }

    public void setEmpassid(String empassid) {
        this.empassid = empassid;
    }

    public String getEmppass() {
        return emppass;
    }

    public void setEmppass(String emppass) {
        this.emppass = emppass;
    }

    public String getEmpfirst() {
        return empfirst;
    }

    public void setEmpfirst(String empfirst) {
        this.empfirst = empfirst;
    }

    public String getEmplast() {
        return emplast;
    }

    public void setEmplast(String emplast) {
        this.emplast = emplast;
    }

    public String getEmpemail() {
        return empemail;
    }

    public void setEmpemail(String empemail) {
        this.empemail = empemail;
    }

    public Integer getEmpphone() {
        return empphone;
    }

    public void setEmpphone(Integer empphone) {
        this.empphone = empphone;
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
        hash += (empid != null ? empid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEmployee)) {
            return false;
        }
        TbEmployee other = (TbEmployee) object;
        if ((this.empid == null && other.empid != null) || (this.empid != null && !this.empid.equals(other.empid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbEmployee[ empid=" + empid + " ]";
    }
    
}
