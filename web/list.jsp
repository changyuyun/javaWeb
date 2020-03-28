<%--
  Created by IntelliJ IDEA.
  User: chang
  Date: 2020/3/28
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            background-color: red;
        }
        .tool-box{
            margin-bottom: 5px;
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
        <button class="actbutton">delete some</button>
    </div>
    <div>
        <table class="gridtable">
            <tr>
                <th><input type="checkbox"></th>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Sex</th>
                <th>ACTION</th>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>1</td>
                <td>2</td>
                <td>3</td>
                <td>4</td>
                <td><button class="actbutton">delete</button></td>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>1</td>
                <td>2</td>
                <td>3</td>
                <td>4</td>
                <td><button class="actbutton">delete</button></td>
            </tr>
        </table>
    </div>
</div>
<script src="/js/jquery-3.3.1.min.js"></script>
</body>
</html>
