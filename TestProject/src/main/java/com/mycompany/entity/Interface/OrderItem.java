package com.mycompany.entity.Interface;

import com.mycompany.entity.TbOrder;
import com.mycompany.entity.TbProduct;

public interface OrderItem {

    boolean equals(Object object);

    TbOrder getOrderid();

    Integer getOrderitemid();

    double getPrice();

    TbProduct getProid();

    int getQty();

    void setOrderid(TbOrder orderid);

    void setOrderitemid(Integer orderitemid);

    void setPrice(double price);

    void setProid(TbProduct proid);

    void setQty(int qty);

    String toString();
    
}
