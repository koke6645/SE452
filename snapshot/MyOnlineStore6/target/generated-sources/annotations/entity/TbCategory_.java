package entity;

import entity.TbProduct;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-14T23:51:35")
@StaticMetamodel(TbCategory.class)
public class TbCategory_ { 

    public static volatile SingularAttribute<TbCategory, Integer> catid;
    public static volatile SingularAttribute<TbCategory, String> catname;
    public static volatile CollectionAttribute<TbCategory, TbProduct> tbProductCollection;

}