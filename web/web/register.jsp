<%--
  Created by IntelliJ IDEA.
  User: 17901
  Date: 2020/4/9
  Time: 8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        #registerError{
            color: red;
            font-size: 12px;
        }
    </style>

    <meta charset="UTF-8">
    <title>用户注册</title>
</head>
<body>
<h1>用户注册</h1>
<hr>
<form action="regist.do" method="post">
    账号:<input type="text" name="userName"><p>
    密码:<input type="password" name="userPwd"><p>
    邮箱:<input type="email" name="email"><p>
    电话:<input type="text" name="phone"><p>

    <%
        String registerError = (String) request.getAttribute("registerError");

        if (registerError!=null){

    %>

    <div id="registerError"><%= registerError %></div>

    <%}%>


    <input type="submit" value="注册">
</form>
</body>
</html>
