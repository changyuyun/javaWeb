<%@ page import="cn.ityun.web.domain.User2" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: chang
  Date: 2020/3/26
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>el</title>
</head>
<body>
h
${3 > 4}
\${5 == 5}

<%
    request.setAttribute("name", "zhangsan");
    session.setAttribute("name", "zhangsan2");
%>
<h3>el获取值</h3>
<h1>${requestScope.name}</h1>
${sessionScope.name}
${sessionScope.hh}
${name}

<%--获取对象中的元素--%>
<h1>获取对象中的元素</h1>
<%
    User2 user2 = new User2();
    user2.setName("changyuyun");
    user2.setId(1);
    user2.setBirthday(new Date());

    request.setAttribute("u", user2);
%>

<%--el 获取数据--%>
${requestScope.u}
<%--通过对象的属性来获取--%>
${requestScope.u.name}
${requestScope.u.id}
${requestScope.u.birthdayStr}

<h1>获取List，Map中的元素</h1>
<%
    List<String> list = new ArrayList<>();
    list.add("name");
    list.add("sex");
    list.add("age");
    request.setAttribute("list", list);

    Map<String, String> map = new HashMap<>();
    map.put("name", "cyy");
    map.put("sex","男");
    map.put("age", "1");
    request.setAttribute("map", map);
%>
${requestScope.list}
${requestScope.list.get(0)}
${requestScope.list.get(1)}
${requestScope.list.get(2)}

${requestScope.map}
${requestScope.map.sex}
</body>
</html>
