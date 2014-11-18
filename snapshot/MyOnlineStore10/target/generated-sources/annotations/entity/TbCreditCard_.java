package entity;

import entity.TbCustomer;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-15T12:50:30")
@StaticMetamodel(TbCreditCard.class)
public class TbCreditCard_ { 

    public static volatile CollectionAttribute<TbCreditCard, TbCustomer> tbCustomerCollection;
    public static volatile SingularAttribute<TbCreditCard, Integer> creditid;
    public static volatile SingularAttribute<TbCreditCard, Integer> cardnumber;
    public static volatile SingularAttribute<TbCreditCard, Integer> cardexpire;

}