<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: chang
  Date: 2020/3/27
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入jar包--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
<%--
JSTL标签
    if
    choose
    foreach
--%>
<%
    List list = new ArrayList();
    list.add("chang");
    request.setAttribute("list", list);
    request.setAttribute("number", 5);

    request.setAttribute("week", 1);
%>

<%--if--%>
<c:if test="${not empty requestScope.list}">
    <h1>遍历集合。。。。</h1>
</c:if>

<c:if test="${requestScope.number % 2 !=0}">
    <h1>${requestScope.number}我不是偶数</h1>
</c:if>

<%--choose--%>
<c:choose>
    <c:when test="${week ==  1}">week 1</c:when>
    <c:when test="${week ==  2}">week 2</c:when>
    <c:when test="${week ==  3}">week 3</c:when>
    <c:when test="${week ==  4}">week 4</c:when>
    <c:when test="${week ==  5}">week 5</c:when>
    <c:when test="${week ==  6}">week 6</c:when>
    <c:when test="${week ==  7}">week 7</c:when>

</c:choose>

<%
    List list2 = new ArrayList();
    list2.add("aaa");
    list2.add("bbb");
    list2.add("ccc");
    list2.add("ddd");
    request.setAttribute("list2", list2);
%>
<%--foreach--%>
<c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
    <h3>${i}  ${s.index} ${s.count}<br></h3>
</c:forEach>

<c:forEach items="${list2}" var="str" varStatus="s">
    <h5>${s.index} ${s.count} ${str}</h5>
</c:forEach>
</body>
</html>
