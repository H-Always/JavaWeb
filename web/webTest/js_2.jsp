<%--
  Created by IntelliJ IDEA.
  User: 17901
  Date: 2020/3/26
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>调用测试</title>
    <script type="text/javascript" src="../javascript/js.js"></script>

    <style>
        #win{
            width: 1300px;
            height: 500px;
            border: 1px solid #595954;

            display: none;
        }

        #title{
            background-color: azure;
            color: lightblue;
            width: 1300px;
            height: 20px;
        }
        #tc{
            line-height: 20px;
        }
        #cbtn{
            margin-left: 1215px;
            cursor: pointer;
        }
        #content{
            width: 1300px;
            height: 480px;
            background-color: lightgoldenrodyellow;
            color: mediumaquamarine;
        }
    </style>

</head>
<body>
    <input type="button" value="方式1" onclick="test()">
    <input type="button" value="方式2" onclick="world()">
    <input type="button" value="方式3" onclick="input()">
    <input type="button" value="方式3" onclick="test1()">

    <hr>
    <h1>输出乘法口诀</h1>
    <hr>
    输入行数
    <input type="number" id="rows">
    <input type="button" value="显示" onclick="showWin()">

    <div id="win">
        <div id="title">
            <span id="tc">窗口标题</span>
            <span id="cbtn" onclick="closeWin();">X</span>
        </div>
        <div id="content">正文</div>
    </div>


</body>
</html>
