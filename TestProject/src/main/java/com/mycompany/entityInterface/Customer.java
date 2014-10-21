package com.mycompany.entityInterface;

import com.mycompany.entity.TbAddress;
import com.mycompany.entity.TbCreditCard;

public interface Customer {

    boolean equals(Object object);

    TbCreditCard getCreditid();

    String getCusassid();

    TbAddress getCusbilladd();

    String getCusemail();

    String getCusfirst();

    Integer getCusid();

    String getCuslast();

    String getCuspass();

    Integer getCusphone();

    TbAddress getCusshipadd();

    void setCreditid(TbCreditCard creditid);

    void setCusassid(String cusassid);

    void setCusbilladd(TbAddress cusbilladd);

    void setCusemail(String cusemail);

    void setCusfirst(String cusfirst);

    void setCusid(Integer cusid);

    void setCuslast(String cuslast);

    void setCuspass(String cuspass);

    void setCusphone(Integer cusphone);

    void setCusshipadd(TbAddress cusshipadd);

    String toString();
    
}
