package com.mycompany.entity.Interface;

public interface Address {

    boolean equals(Object object);

    Integer getAddid();

    String getAddline1();

    String getAddstate();

    int getAddzip();

    void setAddid(Integer addid);

    void setAddline1(String addline1);

    void setAddstate(String addstate);

    void setAddzip(int addzip);

    String toString();
    
}
