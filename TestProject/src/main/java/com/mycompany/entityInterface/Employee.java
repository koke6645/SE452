package com.mycompany.entityInterface;

public interface Employee {

    boolean equals(Object object);

    String getEmpassid();

    String getEmpemail();

    String getEmpfirst();

    Integer getEmpid();

    String getEmplast();

    String getEmppass();

    Integer getEmpphone();

    void setEmpassid(String empassid);

    void setEmpemail(String empemail);

    void setEmpfirst(String empfirst);

    void setEmpid(Integer empid);

    void setEmplast(String emplast);

    void setEmppass(String emppass);

    void setEmpphone(Integer empphone);

    String toString();
    
}
