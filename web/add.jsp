<%--
  Created by IntelliJ IDEA.
  User: chang
  Date: 2020/3/29
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
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
<h3>add user</h3>
<form action="${pageContext.request.contextPath}/AddUserServlet" method="post">
    <div class="input-div">
        <div class="input-title">
            <span>Username&nbsp;&nbsp;</span>
        </div>
        <input type="text" id="username" name="username">
    </div>
    <div class="input-div">
        <div class="input-title">
            <span>Email&nbsp;&nbsp;</span>
        </div>
        <input type="text" id="email" name="email">
    </div>
    <div class="input-div">
        <div class="input-title">
        <span>Birthday&nbsp;&nbsp;</span>
        </div>
        <input type="text" id="birthday" name="birthday">
    </div>
    <div class="input-div">
        <div class="input-title">
        <span>Sex&nbsp;&nbsp;</span>
        </div>
        <input type="radio" name="sex" value="男" checked>男
        <input type="radio" name="sex" value="女">女
    </div>
    <div class="input-div">
        <button type="submit">Add</button>
    </div>
</form>
</body>
</html>
