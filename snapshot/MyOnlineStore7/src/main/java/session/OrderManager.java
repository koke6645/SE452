/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import cart.ShoppingCart;
import cart.ShoppingCartItem;
import entity.TbAddress;
import entity.TbCreditCard;
import entity.TbCustomer;
import entity.TbOrder;
import entity.TbOrderItem;
import entity.TbProduct;
import entity.TbStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
        
/**
 *
 * @author RedPencil
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OrderManager {

    @EJB
    private TbStatusFacade statusFacade;
    @EJB
    private TbOrderFacade orderFacade;
    @EJB
    private TbOrderItemFacade orderItemFacade;
    @EJB
    private TbProductFacade productFacade;
    
    @PersistenceContext(unitName = "mypersis")
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int placeOrder(String first, String last, String address, String state, String zip, String email, String phone, String creditcard, String cardexp, ShoppingCart cart) {

        try {
            TbAddress cusAddress = addAddress(address, state, zip);
            TbCreditCard card = addCard(creditcard, cardexp);
            TbCustomer customer = addCustomer(cusAddress, card, first, last, email, phone);
            TbOrder order = addOrder(customer, cart);
            addOrderedItems(order, cart);

            return order.getOrderid();
            
        } catch (Exception e) {
            return 0;
        }            
    }

    private TbAddress addAddress(String address, String state, String zip) {

        TbAddress cusAdd = new TbAddress(address, state, Integer.parseInt(zip));
        
        em.persist(cusAdd);
        return cusAdd;
    }

    private TbCreditCard addCard(String creditcard, String cardexp) {

        TbCreditCard card = new TbCreditCard(Integer.parseInt(creditcard), Integer.parseInt(cardexp));
 
        em.persist(card);
        return card;
    }

    private TbCustomer addCustomer(TbAddress address, TbCreditCard card, String first, String last, String email, String phone) {
                
        TbCustomer customer = new TbCustomer("A", "B", first, last, email);
        customer.setCusphone(Integer.parseInt(phone));
        customer.setCusbilladd(address);
        customer.setCusshipadd(address);
        customer.setCreditid(card);
                
        em.persist(customer);
        return customer;
    }

    private TbOrder addOrder(TbCustomer customer, ShoppingCart cart) {

        TbStatus status = statusFacade.find(4);
        
        TbOrder order = new TbOrder();
        order.setCusid(customer);
        order.setOrderdate(111214);
        order.setOrderstatus(null);
        order.setOrderstatus(status);
        
        em.persist(order);
        return order;
    }

    private void addOrderedItems(TbOrder order, ShoppingCart cart) {

        em.flush();
        
        List<ShoppingCartItem> items = cart.getItems();
        
        for (ShoppingCartItem scItem : items) {
            
            TbOrderItem orderItem = new TbOrderItem();
            orderItem.setOrderid(order);
            orderItem.setProid(scItem.getProduct());
            orderItem.setPrice(scItem.getProduct().getPrice());
            orderItem.setQty(scItem.getQuantity());
            
            em.persist(orderItem);
        }
    }
    /*
    public Map getOrderDetails(int orderId) {

        Map orderMap = new HashMap();

        TbOrder order = orderFacade.find(orderId);

        TbCustomer customer = order.getCusid();

        List<TbOrderItem> orderItems = orderItemFacade.findByOrderId(orderId);
        

        // get product details for ordered items
        List<TbProduct> products = new ArrayList<TbProduct>();

        for (TbOrderItem op : orderItems) {

            TbProduct p = (TbProduct) productFacade.find(op.getProid());
            products.add(p);
        }

        // add each item to orderMap
        orderMap.put("orderRecord", order);
        orderMap.put("customer", customer);
        orderMap.put("orderItems", orderItems);
        orderMap.put("products", products);

        return orderMap;
    }
    */
}
