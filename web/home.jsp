<%--
  Created by IntelliJ IDEA.
  User: chang
  Date: 2020/3/25
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie :cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            out.println(name +"==="+ value);
        }
    }
%>
</body>
</html>
