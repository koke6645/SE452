package entity;

import entity.TbOrder;
import entity.TbProduct;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-13T18:49:16")
@StaticMetamodel(TbStatus.class)
public class TbStatus_ { 

    public static volatile CollectionAttribute<TbStatus, TbOrder> tbOrderCollection;
    public static volatile SingularAttribute<TbStatus, Integer> statusid;
    public static volatile SingularAttribute<TbStatus, String> statusstate;
    public static volatile CollectionAttribute<TbStatus, TbProduct> tbProductCollection;

}