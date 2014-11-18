package entity;

import entity.TbCustomer;
import entity.TbOrderItem;
import entity.TbStatus;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-11T15:24:24")
@StaticMetamodel(TbOrder.class)
public class TbOrder_ { 

    public static volatile SingularAttribute<TbOrder, TbStatus> orderstatus;
    public static volatile SingularAttribute<TbOrder, Integer> orderid;
    public static volatile SingularAttribute<TbOrder, TbCustomer> cusid;
    public static volatile CollectionAttribute<TbOrder, TbOrderItem> tbOrderItemCollection;
    public static volatile SingularAttribute<TbOrder, Integer> orderdate;

}