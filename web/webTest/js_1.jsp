<%--
  Created by IntelliJ IDEA.
  User: 17901
  Date: 2020/3/26
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>js</title>
</head>
<body>
    <h1>编码方式</h1>
    <hr>
    <h2>方式1：js直接嵌入heml标签</h2>
    <input type="button" value="方式1" onclick="alert('AMD YES')">
    <h2>方式2</h2>
    <script type="text/javascript">
        function hello(){
            alert('Intel come on');
        }
    </script>
    <input type="button" value="方式2" onclick="hello()">
    <h2>方式3:</h2>
    <input type="button" value="方式3" onclick="world()">
</body>
</html>
