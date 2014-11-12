/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TbOrderItem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RedPencil
 */
@Stateless
public class TbOrderItemFacade extends AbstractFacade<TbOrderItem> {
    @PersistenceContext(unitName = "mypersis")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbOrderItemFacade() {
        super(TbOrderItem.class);
    }
    
}
