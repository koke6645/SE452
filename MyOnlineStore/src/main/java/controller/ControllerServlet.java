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
import session.OrderManager;
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
    
    @EJB
    private TbCategoryFacade categoryFacade;
    @EJB
    private TbProductFacade productFacade;
    @EJB
    private OrderManager orderManager;
    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        
        super.init(servletConfig);
        
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
                
        if (userPath.equals("/products")) {
            
            String categoryId = request.getQueryString();
            
            if (categoryId != null) {
                selectedCategory = categoryFacade.find(Integer.parseInt(categoryId));
                
                request.setAttribute("selectedCategory", selectedCategory);
                
                categoryProducts = selectedCategory.getTbProductCollection();
                
                request.setAttribute("categoryProducts", categoryProducts);
            }

        } else if (userPath.equals("/viewCart")) {

            String clear = request.getParameter("clear");

            if ((clear != null) && clear.equals("true")) {

                ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
                cart.clear();
            }
            
            userPath = "/cart";

        } else if (userPath.equals("/checkout")) {

            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

            cart.calculateTotal();

        }
        
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
        
        if (userPath.equals("/addToCart")) {

            if (cart == null) {

                cart = new ShoppingCart();
                session.setAttribute("cart", cart);
            }

            String productId = request.getParameter("productId");

            if (!productId.isEmpty()) {

                TbProduct product = productFacade.find(Integer.parseInt(productId));
                cart.addItem(product);
            }

            userPath = "/products";

        } else if (userPath.equals("/updateCart")) {

            String productId = request.getParameter("productId");
            String quantity = request.getParameter("quantity");

            TbProduct product = productFacade.find(Integer.parseInt(productId));
            cart.update(product, quantity);

            userPath = "/cart";

        } else if (userPath.equals("/purchase")) {

            if (cart != null) {
                String first = request.getParameter("first");
                String last = request.getParameter("last");
                String address = request.getParameter("address");
                String state = request.getParameter("state");
                String zip = request.getParameter("zip");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String creditcard = request.getParameter("creditcard");
                String cardexp = request.getParameter("cardexp");   
                
                int orderId = orderManager.placeOrder(first, last, address, state, zip, email, phone, creditcard, cardexp, cart);
                if (orderId != 0) {

                    cart = null;

                    session.invalidate();

                    userPath = "/confirmation";

                } else {
                    userPath = "/checkout";
                }
            }   

        }

        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}