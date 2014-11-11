<%-- 
    Document   : test_jpa
    Created on : Nov 10, 2014, 12:56:53 PM
    Author     : RedPencil
--%>

<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="com.mycompany.entity.TbEmployee"%>
<%

    
    String PERSISTENCE_UNIT_NAME = "myem1";
    
    EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = factory.createEntityManager();
    
    em.getTransaction().begin();

    TbEmployee emp1 = new TbEmployee();
    emp1.setEmpemail("john1@yahoo.com");
    emp1.setEmpassid("john12233");
    emp1.setEmppass("johnpwd");
    emp1.setEmpfirst("John");
    emp1.setEmplast("Doe");
    emp1.setEmpphone(2323);
    
    em.persist(emp1);
    em.getTransaction().commit();

    em.close();
    
    // com.mycompany_TestProject_war_1.0-SNAPSHOTPU
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
