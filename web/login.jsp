<%--
  Created by IntelliJ IDEA.
  User: chang
  Date: 2020/3/29
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
</head>
<body>
<h3>登陆</h3>
<form action="${pageContext.request.contextPath}/LoginServlet" method="post" onsubmit="return submit()">
    <input type="text" name="name" id="name" value="" placeholder="用户名"/><br>
    <input type="password" name="pwd" id="pwd" value="" placeholder="密码"><br>
    <input type="text" name="code" id="code" value="" placeholder="验证码">
    <img src="${pageContext.request.contextPath}/CheckCode2" id="ccc"><br>
    <input type="submit" value="登陆">
</form>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
    window.onload = function () {
        var code = document.getElementById("ccc");
        var date1 = new Date().getTime();
        code.src = "${pageContext.request.contextPath}/CheckCode2?s="+date1;
        code.onclick = function () {
            var date = new Date().getTime();
            code.src = "${pageContext.request.contextPath}/CheckCode2?s="+date;
        }
    };
    function submit() {
        var name = $("#name").val();
        var pwd = $("#pwd").val();
        if (name == '') {
            alert("name can not been empty");
            return false;
        }
        if (pwd == '') {
            alert("pwd can not been empty");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
