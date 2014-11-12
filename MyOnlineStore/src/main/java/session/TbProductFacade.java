/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TbProduct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RedPencil
 */
@Stateless
public class TbProductFacade extends AbstractFacade<TbProduct> {
    @PersistenceContext(unitName = "mypersis")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbProductFacade() {
        super(TbProduct.class);
    }
    
}
