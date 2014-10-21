package com.mycompany.entity;

import com.mycompany.entityInterface.Employee;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
public class TbEmployee implements Serializable, Employee {
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

    @Override
    public Integer getEmpid() {
        return empid;
    }

    @Override
    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    @Override
    public String getEmpassid() {
        return empassid;
    }

    @Override
    public void setEmpassid(String empassid) {
        this.empassid = empassid;
    }

    @Override
    public String getEmppass() {
        return emppass;
    }

    @Override
    public void setEmppass(String emppass) {
        this.emppass = emppass;
    }

    @Override
    public String getEmpfirst() {
        return empfirst;
    }

    @Override
    public void setEmpfirst(String empfirst) {
        this.empfirst = empfirst;
    }

    @Override
    public String getEmplast() {
        return emplast;
    }

    @Override
    public void setEmplast(String emplast) {
        this.emplast = emplast;
    }

    @Override
    public String getEmpemail() {
        return empemail;
    }

    @Override
    public void setEmpemail(String empemail) {
        this.empemail = empemail;
    }

    @Override
    public Integer getEmpphone() {
        return empphone;
    }

    @Override
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
        return "com.mycompany.entity.TbEmployee[ empid=" + empid + " ]";
    }
    
}
