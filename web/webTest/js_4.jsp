<%--
  Created by IntelliJ IDEA.
  User: 17901
  Date: 2020/3/31
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style type="text/css">
        span{
            color: darkseagreen;
            font-size: 12px;
        }
    </style>


    <script type="text/javascript">
        function showTime() {
            let date = new Date();
            time.innerHTML = date.toLocaleString();
        }
        function test6() {
            showTime();
            timeer = window.setInterval("showTime()",200);
        }
        function timeStop() {
            //清楚定时器
            window.clearInterval(timeer);
        }

    </script>


</head>
<body>
    <h1>windows 常用对象</h1>
    <hr>
    <input type="button" value="按钮" id="button">
    <input type="button" value="按钮2" id="button2">
    <input type="button" value="按钮3" id="button3">
    <a href="index4.jsp" id="index2">删除</a>

    <script type="text/javascript">
        button.onclick = function () {
            window.alert("这是一条语句")
        };

        button2.onclick = function () {
            //带指定消息确认和取消的对话框
            let r = window.confirm("这是另一条语句");
            console.log(r);
        };
        button3.onclick = function () {
            //带输入框的按钮
             let a = window.prompt("hello","请输入");
             console.log(a);
        };
        index2.onclick = function () {
            let l = window.confirm("点击确定就会世界毁灭!");
            console.log(l);
        };


    </script>

</body>


<body onload="test6();">
    <h1>定时器</h1>
    <hr>
    <h2 id="time" onclick="timeStop()"></h2>

</body>

<body>
    <h1>用户注册</h1>
    <form action="js_4.jsp" method="post">
        账号<input type="text" name = "userName" id="userName" onblur="checkUserName();">
        <span id="unsp"></span><p>
        密码<input type = "password" name="userPassword" id="userPassword" onblur="checkUserPassword();">
        <span id="upsp"></span><p>
        邮箱<input type="text" name="email" id="email" onblur="checkEmail();">
        <span id="uesp"></span><p>
        电话<input type="text" name="phone" id="phone" onblur="checkPhone();">
        <span id="upshp"></span><p>
        <input type="submit" value="注册" onblur="return checkForm();">
    </form>

    <script type="text/javascript">
        function checkUserName() {
            if (userName.value === ""){
                unsp.innerHTML = "小伙汁，账号你啥也没输入鸭~";
                return false;
            }
            return true;
        }

        //密码验证
        function checkUserPassword() {
            if (userPassword.value === ""){
                upsp.innerHTML = "小伙汁，密码你啥也没输入鸭~";
                return false;
            }
            return true;
        }

        //邮箱验证
        function checkEmail(){
            const reg = /^\w+@\w+(\.\w+)+$/;
            if(!reg.test(email.value)){
                uesp.innerHTML="小伙汁，你邮箱格式错误!";
                return false;
            }
            return true;

        }

        function checkPhone() {
            let reg = /^[1][3|4|5|6|7|8|9]\d{9}$/;
            if (!reg.test(phone.value)){
                upshp.innerHTML = "错误";
                return false;
            }
            return true;

        }

        function checkForm() {
            let r1 = checkUserName();
            let r2 = checkUserPassword();
            let r3 = checkEmail();
            let r4 = checkPhone();
            return r1 & r2 & r3 & r4;
        }

    </script>

</body>
</html>
