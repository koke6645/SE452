<%-- 
    Document   : test_address
    Created on : Oct 22, 2014, 1:06:52 PM
    Author     : RedPencil
--%>

<%@page import="javax.persistence.EntityManager"%>
<%@page import="com.mycompany.entity.TbCategory"%>
<%@page import="com.mycompany.entity.TbAddress"%>
<%

    TbAddress addr1 = new TbAddress();
    addr1.setAddline1("123 n road1");
    
    TbCategory cat1 = new TbCategory();
    
    //EntityManager ent1 = new EntityManager("jdbc:mysql://localhost/ao_test", "user", "password");
    //ent1.persist(addr1);
    //EntityManager.persist(addr1);
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
