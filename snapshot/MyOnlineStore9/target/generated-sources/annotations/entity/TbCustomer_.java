package entity;

import entity.TbAddress;
import entity.TbCreditCard;
import entity.TbOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-15T04:29:42")
@StaticMetamodel(TbCustomer.class)
public class TbCustomer_ { 

    public static volatile SingularAttribute<TbCustomer, String> cuslast;
    public static volatile SingularAttribute<TbCustomer, TbAddress> cusshipadd;
    public static volatile SingularAttribute<TbCustomer, TbAddress> cusbilladd;
    public static volatile SingularAttribute<TbCustomer, TbCreditCard> creditid;
    public static volatile CollectionAttribute<TbCustomer, TbOrder> tbOrderCollection;
    public static volatile SingularAttribute<TbCustomer, Integer> cusid;
    public static volatile SingularAttribute<TbCustomer, String> cusfirst;
    public static volatile SingularAttribute<TbCustomer, String> cusemail;
    public static volatile SingularAttribute<TbCustomer, Integer> cusphone;
    public static volatile SingularAttribute<TbCustomer, String> cuspass;
    public static volatile SingularAttribute<TbCustomer, String> cusassid;

}