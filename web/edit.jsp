<%--
  Created by IntelliJ IDEA.
  User: chang
  Date: 2020/3/29
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入jar包--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>edit</title>
    <style>
        .input-div{
            margin-bottom: 5px;
        }
        .input-title{
            display: inline;
            text-align: right;
            width: 50px;
            margin-right: 10px;
        }
    </style>
</head>
<body>
<h3>edit user</h3>
<form action="${pageContext.request.contextPath}/EditUserServlet" method="post">
    <input type="hidden" name="id" value="${user.getId()}">
    <div class="input-div">
        <div class="input-title">
            <span>Username&nbsp;&nbsp;</span>
        </div>
        <input type="text" id="username" name="username" value="${user.getUsername()}">
    </div>
    <div class="input-div">
        <div class="input-title">
            <span>Email&nbsp;&nbsp;</span>
        </div>
        <input type="text" id="email" name="email" value="${user.getEmail()}">
    </div>
    <div class="input-div">
        <div class="input-title">
            <span>Birthday&nbsp;&nbsp;</span>
        </div>
        <input type="text" id="birthday" name="birthday" value="${user.getBirthday()}">
    </div>
    <div class="input-div">
        <div class="input-title">
            <span>Sex&nbsp;&nbsp;</span>
        </div>
        <c:choose>
            <c:when test="${user.getSex() == '男'}">
                <input type="radio" name="sex" value="男" checked>男
                <input type="radio" name="sex" value="女">女
            </c:when>
            <c:otherwise>
                <input type="radio" name="sex" value="男">男
                <input type="radio" name="sex" value="女" checked>女
            </c:otherwise>
        </c:choose>


    </div>
    <div class="input-div">
        <button type="submit">Edit</button>
    </div>
</form>
</body>
</html>
