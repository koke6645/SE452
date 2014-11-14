<%-- 
    Document   : cart
    Created on : Nov 3, 2014, 5:32:25 PM
    Author     : RedPencil
--%>

            <div id="centerColumn">

                <c:choose>
                    <c:when test="${cart.numberOfItems > 1}">
                        <p>Your shopping cart contains ${cart.numberOfItems} items.</p>
                    </c:when>
                    <c:when test="${cart.numberOfItems == 1}">
                        <p>Your shopping cart contains ${cart.numberOfItems} item.</p>
                    </c:when>
                    <c:otherwise>
                        <p>Your shopping cart is empty.</p>
                    </c:otherwise>
                </c:choose>
                    
                <c:if test="${!empty cart && cart.numberOfItems != 0}">
                    <table id="cartTable">
                        <tr class="header">
                            <th>product</th>
                            <th>name</th>
                            <th>price</th>
                            <th>quantity</th>
                        </tr>
                        
                        <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">
                            <c:set var="product" value="${cartItem.product}"/>
                            
                            <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                                <td>
                                    <img src="#" alt="product image">
                                </td>
                                <td>${product.proname}</td>
                                <td>$ ${product.price}</td>
                                <td>
                                    <form action="updateCart" method="post">
                                        <input type="hidden"
                                               name="productId"
                                               value="${product.proid}">
                                        <input type="text"
                                               maxlength="2"
                                               size="2"
                                               value="${cartItem.quantity}"
                                               name="quantity">
                                        <input type="submit"
                                               name="submit"
                                               value="update">
                                    </form>
                                </td>
                            </tr>
                            
                        </c:forEach>                        
                    </table>
                    <h4 id="subtotal">subtotal: $ ${cart.subtotal}</h4>
                </c:if>    
                 
                <div id="actionBar">
                    
                    <c:if test="${!empty cart && cart.numberOfItems != 0}">
                        <a href="viewCart?clear=true" class="bubble hMargin">clear cart</a>
                    </c:if>
                    <%--
                    <c:set var="backtoshop">
                        <c:choose>
                            <c:when test="${!empty selectedCategory}">
                                category
                            </c:when>
                            <c:otherwise>
                                index.jsp
                            </c:otherwise>
                        </c:choose>
                    </c:set>
                    --%>
                    <a href="products" class="bubble hMargin">continue shopping</a>

                    <c:if test="${!empty cart && cart.numberOfItems != 0}">
                        <a href="checkout" class="bubble hMargin">proceed to checkout</a>
                    </c:if>

                </div>


            </div>
