<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : products
    Created on : Nov 3, 2014, 5:33:01 PM
    Author     : RedPencil
--%>
<%--
<sql:query var="categories" dataSource="jdbc/mydb">
    SELECT * FROM TB_CATEGORY
</sql:query>
    
<sql:query var="selectedCategory" dataSource="jdbc/mydb">
    SELECT CATNAME FROM TB_CATEGORY WHERE CATID = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>
    
<sql:query var="categoryProducts" dataSource="jdbc/mydb">
    SELECT * FROM TB_PRODUCT WHERE CATID = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>
--%>    
            <div id="category">
                <h3>Category</h3>
                <ul>
                    <c:forEach var="category" items="${categories}">  
                        <li><a href="products?${category.catid}">${category.catname}</a></li>
                    </c:forEach>
                </ul>
            </div>
            
            <div id="itemList">
                <h3 class="smallText">${selectedCategory.rows[0].catname}</h3>
                <table id="productTable">
                    <c:forEach var="product" items="${categoryProducts.rows}" varStatus="iter">
                        <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                            <td>
                                <img src="#" alt="product image">
                            </td>
                            <td>${product.proname}</td>
                            <td>$ ${product.price}</td>
                            <td>
                                <form action="addToCart" method="post">
                                    <input type="hidden"
                                           name="productId"
                                           value="${product.proid}">
                                    <input type="submit"
                                           value="add to cart">
                                </form>
                            </td>
                    </c:forEach>
                </table>
            </div>
            
