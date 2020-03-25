<%--
  Created by IntelliJ IDEA.
  User: chang
  Date: 2020/3/18
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    System.out.println("hello jsp");
    String contextPath = request.getContextPath();
    out.println(contextPath);
  %>
  <%
    out.println("hello");
  %>
  <%
    response.getWriter().println("response");
  %>

  </body>
</html>
