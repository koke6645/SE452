/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cart.ShoppingCart;
import entity.TbCategory;
import entity.TbProduct;
import java.io.IOException;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.TbCategoryFacade;
import session.TbProductFacade;

/**
 *
 * @author RedPencil
 */
@WebServlet(name="ControllerServlet", 
        loadOnStartup = 1,
        urlPatterns={"/products", 
                     "/addToCart",
                     "/viewCart",
                     "/updateCart",
                     "/checkout",
                     "/purchase",})
public class ControllerServlet extends HttpServlet {

    private String surcharge;
    
    @EJB
    private TbCategoryFacade categoryFacade;
    @EJB
    private TbProductFacade productFacade;
    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        
        super.init(servletConfig);
        
        surcharge = servletConfig.getServletContext().getInitParameter("deliverySurcharge");

        getServletContext().setAttribute("categories", categoryFacade.findAll());
    }
    
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        TbCategory selectedCategory;
        Collection<TbProduct> categoryProducts;
                
        // if category page is requested
        if (userPath.equals("/products")) {
            
            String categoryId = request.getQueryString();
            
            if (categoryId != null) {
                selectedCategory = categoryFacade.find(Integer.parseInt(categoryId));
                
                request.setAttribute("selectedCategory", selectedCategory);
                
                categoryProducts = selectedCategory.getTbProductCollection();
                
                request.setAttribute("categoryProducts", categoryProducts);
            }

            // if cart page is requested
        } else if (userPath.equals("/viewCart")) {

            String clear = request.getParameter("clear");

            if ((clear != null) && clear.equals("true")) {

                ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
                cart.clear();
            }
            
            userPath = "/cart";

        // if checkout page is requested
        } else if (userPath.equals("/checkout")) {

            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

            // calculate total
            cart.calculateTotal(surcharge);

        }
        
        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        
        // if addToCart action is called
        if (userPath.equals("/addToCart")) {

            // if user is adding item to cart for first time
            // create cart object and attach it to user session
            if (cart == null) {

                cart = new ShoppingCart();
                session.setAttribute("cart", cart);
            }

            // get user input from request
            String productId = request.getParameter("productId");

            if (!productId.isEmpty()) {

                TbProduct product = productFacade.find(Integer.parseInt(productId));
                cart.addItem(product);
            }

            userPath = "/products";

        // if updateCart action is called
        } else if (userPath.equals("/updateCart")) {

            // get input from request
            String productId = request.getParameter("productId");
            String quantity = request.getParameter("quantity");

            TbProduct product = productFacade.find(Integer.parseInt(productId));
            cart.update(product, quantity);

            userPath = "/cart";

        // if purchase action is called
        } else if (userPath.equals("/purchase")) {
            // TODO: Implement purchase action

            userPath = "/confirmation";
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}