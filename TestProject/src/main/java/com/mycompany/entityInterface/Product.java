package com.mycompany.entityInterface;

import com.mycompany.entity.TbCategory;
import com.mycompany.entity.TbEmployee;
import com.mycompany.entity.TbStatus;

public interface Product {

    boolean equals(Object object);

    TbCategory getCatid();

    TbEmployee getLastupdate();

    double getPrice();

    Integer getProid();

    String getProinfo();

    String getProname();

    TbStatus getProstatus();

    void setCatid(TbCategory catid);

    void setLastupdate(TbEmployee lastupdate);

    void setPrice(double price);

    void setProid(Integer proid);

    void setProinfo(String proinfo);

    void setProname(String proname);

    void setProstatus(TbStatus prostatus);

    String toString();
    
}
