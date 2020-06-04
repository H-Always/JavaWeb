<%--
  Created by IntelliJ IDEA.
  User: 17901
  Date: 2020/3/30
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" >
        function test2() {
            let str1 = "javaScript";
            console.log(str1.length);
        }

        function random() {
            let num = Math.random();
            console.log(num);
            num = Math.round(num);
            console.log(num);
        }
        function test3() {
            let date = new Date();
            showTime.innerHTML = date.toLocaleString();
        }

        //正则
        function test4() {
            let regExp = new RegExp("[1-9][0-9]");
            let string  = "13";
            let r1 = regExp.test(string);
            console.log(r1)
        }
        function test5() {
            let regExp = /^[0-9]{6}$/;
            let string  = "131212asd";
            let r1 = regExp.test(string);
            console.log(r1)
        }

        function Email() {
            let regExp = /^\w+@\w+(\.\w+)+$/;
            let string  = "1790199849@qq.com";
            let r1 = regExp.test(string);
            console.log(r1)
        }
    </script>
</head>
<body onload="test3()">
    <h1>测试String</h1>
    <hr>
    <div id="showTime" ></div>
    <input type="button" value="test1" onclick="test2()">
    <input type="button" value="testRandom" onclick="random()">
    <input type="button" value="reg" onclick="test4()">
    <input type="button" value="reg" onclick="test5()">
    <input type="button" value="email" onclick="email()">


</body>
</html>
