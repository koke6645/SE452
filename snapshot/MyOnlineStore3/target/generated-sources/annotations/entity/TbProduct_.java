package entity;

import entity.TbCategory;
import entity.TbEmployee;
import entity.TbOrderItem;
import entity.TbStatus;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-13T18:49:16")
@StaticMetamodel(TbProduct.class)
public class TbProduct_ { 

    public static volatile SingularAttribute<TbProduct, TbCategory> catid;
    public static volatile SingularAttribute<TbProduct, String> proinfo;
    public static volatile SingularAttribute<TbProduct, Double> price;
    public static volatile SingularAttribute<TbProduct, Integer> proid;
    public static volatile CollectionAttribute<TbProduct, TbOrderItem> tbOrderItemCollection;
    public static volatile SingularAttribute<TbProduct, TbStatus> prostatus;
    public static volatile SingularAttribute<TbProduct, String> proname;
    public static volatile SingularAttribute<TbProduct, TbEmployee> lastupdate;

}