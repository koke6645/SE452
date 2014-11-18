/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TbCategory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RedPencil
 */
@Stateless
public class TbCategoryFacade extends AbstractFacade<TbCategory> {
    @PersistenceContext(unitName = "mypersis")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbCategoryFacade() {
        super(TbCategory.class);
    }
    
}
