package com.mycompany.entityInterface;

import com.mycompany.entity.TbCustomer;
import com.mycompany.entity.TbOrderItem;
import com.mycompany.entity.TbStatus;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

public interface Order {

    boolean equals(Object object);

    TbCustomer getCusid();

    int getOrderdate();

    Integer getOrderid();

    TbStatus getOrderstatus();

    @XmlTransient
    Collection<TbOrderItem> getTbOrderItemCollection();

    void setCusid(TbCustomer cusid);

    void setOrderdate(int orderdate);

    void setOrderid(Integer orderid);

    void setOrderstatus(TbStatus orderstatus);

    void setTbOrderItemCollection(Collection<TbOrderItem> tbOrderItemCollection);

    String toString();
    
}
