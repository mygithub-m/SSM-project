<%--
  Created by IntelliJ IDEA.
  User: 滑翔的人儿
  Date: 2020/7/19
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <script src="${pageContext.request.contextPath}/js/login.js"></script>
</head>
<body>
<div class="container">
    <div class="login">
        <!-- 登录表单开始 -->
        <form action="${pageContext.request.contextPath}/manager/login" method="get">
            <table class="login_table">
                <tr>
                    <td><label for="text">管理员名：</label></td>
                    <td><input type="text" name="m_name" id="text"></td>
                </tr>
                <tr>
                    <td><label for="password">密&ensp;&ensp;&ensp;&ensp;码：</label></td>
                    <td><input type="password" name="m_password" id="password"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;"><input type="submit" value="登录" class="btn"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>