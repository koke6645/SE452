package com.mycompany.entityInterface;

public interface Category {

    boolean equals(Object object);

    Integer getCatid();

    String getCatname();

    void setCatid(Integer catid);

    void setCatname(String catname);

    String toString();
    
}
