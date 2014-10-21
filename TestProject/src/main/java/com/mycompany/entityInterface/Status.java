package com.mycompany.entityInterface;

public interface Status {

    boolean equals(Object object);

    Integer getStatusid();

    String getStatusstate();

    void setStatusid(Integer statusid);

    void setStatusstate(String statusstate);

    String toString();
    
}
