<%--
  Created by IntelliJ IDEA.
  User: 17901
  Date: 2020/3/9
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <a name="miao"></a>

  <%--这是注释--%>
  <h1>这是我的第一个java web应用</h1>
  <p>在一个月黑风高的夜晚</p>
  <p>
    <%--sub--%>
    2H<sub>2</sub>+O<sub>2</sub>
    <%--<s>删除线 <u>下划线 <i>倾斜 <B>加粗--%>
    <s>股市</s>:在一个<u>月黑风高</u>，有一颗<b>老槐树</b>
  </p>
  <h2>HTML无序</h2>
  <u1>
    <li>javaweb</li>
    <li>web</li>
    <li>servlet</li>
  </u1>
  <%--1,数字
      a,小写字母
      A，大写字母
      i，小写罗马数字
      I大写罗马数字
      start="起始编号"--%>
  <h2>HTML无序</h2>
  <ol type = "I" start = "2">
    <li>javaweb</li>
    <li>web</li>
    <li>servlet</li>
  </ol>


  <a href="mailto:q790199849@qq.com">联系我们</a>

  <a href="#miao">去找喵星人</a>

  <img src="../images/cat.png" width="400" height="600" title="我是猫">


  <form action="index2.jsp" method="get">
    账号: <input type="text" name="username"><p>
    密码: <input type="password" name="password"><p>
    <input type="submit" value="登录">
  </form>

  </body>
</html>
