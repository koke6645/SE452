package entity;

import entity.TbOrder;
import entity.TbProduct;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-13T22:32:53")
@StaticMetamodel(TbOrderItem.class)
public class TbOrderItem_ { 

    public static volatile SingularAttribute<TbOrderItem, TbOrder> orderid;
    public static volatile SingularAttribute<TbOrderItem, Double> price;
    public static volatile SingularAttribute<TbOrderItem, Integer> qty;
    public static volatile SingularAttribute<TbOrderItem, TbProduct> proid;
    public static volatile SingularAttribute<TbOrderItem, Integer> orderitemid;

}