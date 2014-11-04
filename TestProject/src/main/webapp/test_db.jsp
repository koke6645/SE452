<%-- 
    Document   : test_db
    Created on : Nov 3, 2014, 12:30:54 PM
    Author     : RedPencil
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

<%
    
    String connectionUrl = "jdbc:hsqldb:hsql://localhost/mydb";
    String userName = "SA";
    String password = "";

    Connection con = DriverManager.getConnection(connectionUrl, userName, password);
    
    // Driver drv = DriverManager.getConnection(url)org.hsqldb.jdbcDriver" name="jdbc/testProject" password="" type="javax.sql.DataSource" url="jdbc:hsqldb:hsql://localhost/mydb" username="SA"/>

    String sql1 = "SELECT * FROM tb_product";
    Statement stmt = con.createStatement();
    ResultSet rs1 = stmt.executeQuery(sql1);
    if (rs1.next()) {
        do {
            String col2 = rs1.getString("proname");
            %><%= col2 %><br><%
        } while (rs1.next());
    }
    rs1.close();
    stmt.close();
    con.close();
    
%>

    </body>
</html>
