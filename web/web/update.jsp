<%@ page import="com.servlet.User" %><%--
  Created by IntelliJ IDEA.
  User: 17901
  Date: 2020/4/17
  Time: 8:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>修改账号邮箱和手机号</h1>
    <hr>

    <form action="update.do" method="post">
        <% User user = (User) request.getAttribute("user"); %>
        <input type="hidden" name="id" readonly = readonly value="<%= user.getId() %>">
        <p></p>
        邮箱:<input type="email" name="email" value="<%= user.getEmail() %>"><p>
        电话:<input type="text" name="phone" value="<%= user.getPhone() %>"><p>

        <input type="submit" value="修改">

    </form>

</body>
</html>
