/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

//import javax.validation.constraints.NotNull;
import java.io.Serializable;
import javax.persistence.*;

@Entity
//@Cache(type= CacheType.WEAK, expiry=60000)
@NamedQuery(name = "findAllProdAs", query = "select b from ProdA b")
public class ProdA implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;

    @NotNull
    private String prodName;

    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public String getProdName() {
        return prodName;
    }

    @Override
    public void setProdName(String title) {
        this.prodName = title;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ProdA)) {
            return false;
        }
        ProdA other = (ProdA) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", version=" + version + ", name=" + prodName + "'}'";
    }


}
