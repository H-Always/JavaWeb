<%@ page import="java.util.List" %>
<%@ page import="com.servlet.User" %><%--
  Created by IntelliJ IDEA.
  User: 17901
  Date: 2020/4/16
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>显示账号信息</h1>
    <hr>
    <% List<User> list = (List<User>)request.getAttribute("Users"); %>


    <% for (User user : list) { %>
    <ul>
        <li> <%= user.getId() %> </li>
        <li> <%= user.getUsername() %> </li>
        <li> <%= user.getEmail() %> </li>
        <li> <%= user.getPhone() %> </li>
        <li> <%= user.getCreated() %> </li>
        <li> <%= user.getUpdated() %> </li>
    </ul>
    <a href = "delete.do?id=<%= user.getId() %>"
       onclick="return window.confirm('确定删除该数据？')">删除</a>
    <input type="button" value="编辑" onclick="findById(<%= user.getId() %>);">

    <% } %>

<script type="text/javascript">
    function findById(userId) {
        window.location.href="findById.do?id="+userId;
    }
</script>
</body>
</html>
