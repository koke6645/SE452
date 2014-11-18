package entity;

import entity.TbProduct;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-12T04:44:38")
@StaticMetamodel(TbEmployee.class)
public class TbEmployee_ { 

    public static volatile SingularAttribute<TbEmployee, Integer> empid;
    public static volatile SingularAttribute<TbEmployee, Integer> empphone;
    public static volatile SingularAttribute<TbEmployee, String> empfirst;
    public static volatile CollectionAttribute<TbEmployee, TbProduct> tbProductCollection;
    public static volatile SingularAttribute<TbEmployee, String> empemail;
    public static volatile SingularAttribute<TbEmployee, String> emplast;
    public static volatile SingularAttribute<TbEmployee, String> empassid;
    public static volatile SingularAttribute<TbEmployee, String> emppass;

}