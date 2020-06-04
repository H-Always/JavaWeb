<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.servlet.User" %><%--
  Created by IntelliJ IDEA.
  User: 17901
  Date: 2020/4/16
  Time: 8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>

    </style>
    <script type="text/javascript">


    </script>
</head>
<body>
    <h1>JSP</h1>
    <hr>
    <%
        for (int i = 0; i < 10; i++) {%>
            DoYouLikeJava<br>

     <%   }%>


    <%--    --%>

    <%
        List<User> list = new ArrayList<>();
        list.add(new User("aaa","aaa","aaa@aa.aaa","15548444329");




    %>
    <% for (User user : list) { %>
        <ul>
            <li><%= user.getUsername() %></li>
            <li><%= user.getPassword() %></li>
            <li><%= user.getEmail() %></li>
            <li><%= user.getPhone() %></li>
        </ul>
        <input type="button" value="删除">
        <hr width="50%" align="left">

    <%}%>


</body>
</html>
