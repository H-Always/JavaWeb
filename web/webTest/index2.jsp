<%--
  Created by IntelliJ IDEA.
  User: 17901
  Date: 2020/3/23
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单</title>
</head>

<h1>用户注册</h1>

<form action="index1.jsp" method="get">
    账号: <input type="text" name="username" ><p>
    密码: <input type="password" name="password" ><p>
    姓名: <input type="text" name = "name"><p>

    性别: <input type="radio" name = "sex" value="男">男
    <input type="radio" name = "sex" value="女">女<p>
    年龄: <input type="number" name = "age"><p>
    邮箱: <input type="email" name = "email"><p>

    <input type="submit" value="登录">
</form>


<body>

</body>
</html>
