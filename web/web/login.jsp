<%--
  Created by IntelliJ IDEA.
  User: 17901
  Date: 2020/4/9
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #upError{
            color: red;
            font-size: 12px;
        }

    </style>
</head>
<body>
<h1>用户登录</h1>
<h1 class="div1">用户登录！！！！</h1>
<hr>
<form action="login.do" method="post">
<%--  自动登录设置  --%>
    <%
        Cookie[] cookies = request.getCookies();
        String oldUserName = "";
        String oldUserPassword = "";

        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())){
                    oldUserName = cookie.getValue();
                }

                if ("password".equals(cookie.getName())){
                    oldUserPassword = cookie.getValue();
                }


            }
        }

    %>

    username :<input type="text" name="username" value="<%= oldUserName %>"><p>
    password:<input type="password" name="password" value="<%= oldUserPassword %>"><p>

    <%
        String upError= (String) request.getAttribute("upError");
        if (upError != null){
    %>
    <div id = "upError"><%= upError %></div><br>

    <%}%>

    <input type="checkbox" name="isAuto" value="1">记住账号密码<p></p>

    <input type="submit" value="登录">
</form>
</body>
</html>