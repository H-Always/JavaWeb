<%--
  Created by IntelliJ IDEA.
  User: 17901
  Date: 2020/4/28
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.servlet.User" %>
<html>
<head>
    <title>EL的使用</title>
</head>
<body>
    <%= 30*19 %>

    ${30*13212}

    <%
        request.setAttribute("user","张三");
        session.setAttribute("user","李四");

        String name = (String) request.getAttribute("user");

    %>
    <%= name %>

    ${sessionScope.user}

</body>
</html>
