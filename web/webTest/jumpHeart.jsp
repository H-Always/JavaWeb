<%--
  Created by IntelliJ IDEA.
  User: 17901
  Date: 2020/3/26
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jump heart</title>
    <style type="text/css">
        div{
            width: 200px;
            height: 200px;
            background-color: palegoldenrod;
            /* 居中 */
            margin: 300px auto;
            /* 旋转 */
            transform:rotate(135deg);
            /* 高斯模糊 */
            filter: drop-shadow(0px 0px 3px palegoldenrod);
            /* 透明样式 */
            opacity: 0.8;
            animation: m1 0.8s linear infinite;
        }
        div:after{
            content: "";
            width: 200px;
            height: 200px;
            background-color: palegoldenrod;
            border-radius: 50%;
            /* 调整为块级元素显示 */
            display: block;
            position: relative;
            top: -100px;
            left: 0;
        }
        div:before{
            content: "";
            width: 200px;
            height: 200px;
            background-color: palegoldenrod;
            border-radius: 50%;
            /* 调整为块级元素显示 */
            display: block;
            position: relative;
            top: 0;
            left: -100px;
        }

        @keyframes m1 {
            0%{
                transform:rotate(135deg) scale(1,1);
            }
            30%{
                transform:rotate(135deg) scale(0.8,0.8);
            }
            100%{
                transform:rotate(135deg) scale(1.2,1.2);}
        }

    </style>
</head>
<body>
    <div></div>
</body>
</html>
