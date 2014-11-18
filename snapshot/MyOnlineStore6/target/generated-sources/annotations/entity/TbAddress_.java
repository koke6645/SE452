package entity;

import entity.TbCustomer;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-14T23:51:35")
@StaticMetamodel(TbAddress.class)
public class TbAddress_ { 

    public static volatile SingularAttribute<TbAddress, String> addstate;
    public static volatile CollectionAttribute<TbAddress, TbCustomer> tbCustomerCollection1;
    public static volatile CollectionAttribute<TbAddress, TbCustomer> tbCustomerCollection;
    public static volatile SingularAttribute<TbAddress, String> addline1;
    public static volatile SingularAttribute<TbAddress, Integer> addzip;
    public static volatile SingularAttribute<TbAddress, Integer> addid;

}