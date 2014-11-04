<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:query var="rs" dataSource="jdbc/db1">
select proname from tb_product
</sql:query>

<html>
  <head>
    <title>DB Test</title>
  </head>
  <body>

  <h2>Results</h2>
  <table>
      <tr style="background-color: gray; color: white;"><td>Product</td></tr>
<c:forEach var="row" items="${rs.rows}">
    <tr><td>${row.proname}</td></tr>
</c:forEach>
  </table>
  </body>
</html>

