<%--
  Created by IntelliJ IDEA.
  User: chang
  Date: 2020/3/28
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入jar包--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
    <style type="text/css">
        .gridtable {
            font-family: verdana,arial,sans-serif;
            font-size:11px;
            color:#333333;
            border-width: 1px;
            border-color: #666666;
            border-collapse: collapse;
        }
        .gridtable th {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #dedede;
        }
        .gridtable td {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #ffffff;
            }
        .actbutton {
            width: auto;
            height: 20px;
            color: white;
            background-color: cornflowerblue;
            border-radius: 3px;
            border-width: 0;
            margin: 0;
            outline: none;
            font-family: KaiTi;
            font-size: 13px;
            text-align: center;
            cursor: pointer;
        }
        button:hover{
            background-color: #1411ff;
        }
        .tool-box{
            margin-bottom: 5px;
        }
        #page ul {
            list-style: none;
            margin-left: 20px;
        }
        #page li {
            display: inline;
            line-height: 40px;
        }
        a {
            text-decoration: none;
            color: green;
        }
        a:hover {
            color: red;
        }

    </style>
</head>
<body>
<div style="align-content: center">
    <h3>信息列表</h3>
    <div>
        <form>
            <div>
                <span>姓名&nbsp;&nbsp;</span><input type="text" id="name" name="name">
                <span>Email&nbsp;&nbsp;</span><input type="text" id="email" name="email">
                <button type="submit">Search</button>
            </div>
        </form>
    </div>
    <div class="tool-box">
        <button class="actbutton" onclick="location.href='${pageContext.request.contextPath}/home.jsp'">home</button>
        <button class="actbutton">delete some</button>
        <button class="actbutton" onclick="location.href='${pageContext.request.contextPath}/add.jsp'">add user</button>
    </div>
    <div>
        <table class="gridtable">
            <tr>
                <th><input type="checkbox"></th>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Sex</th>
                <th>Birthday</th>
                <th>ACTION</th>
            </tr>
            <c:forEach items="${users}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${user.getId()}</td>
                    <td>${user.getUsername()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getSex()}</td>
                    <td>${user.getBirthday()}</td>
                    <td><button class="actbutton">delete</button></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="page">
        <ul>
            <li><a href="#"> <<< </a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">6</a></li>
            <li><a href="#"> >>> </a></li>
        </ul>
    </div>
</div>
<script src="/js/jquery-3.3.1.min.js"></script>
</body>
</html>
