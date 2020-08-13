<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 滑翔的人儿
  Date: 2020/7/20
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加员工</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/add.css">
    <script src="${pageContext.request.contextPath}/js/add.js"></script>
</head>

<body>
<div class="container">
    <div class="top">
        <div class="path">
            <p>当前位置：<a href="${pageContext.request.contextPath}/employee/list">员工列表</a>>><a href="${pageContext.request.contextPath}/employee/addEmployeePage" class="current">添加员工</a></p>
        </div>
    </div>

    <div class="form">
        <form action="${pageContext.request.contextPath}/employee/addEmployee" method="post">
            <table>
                <tr>
                    <td><label for="name">姓名</label></td>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="e_name" id="name" placeholder="请输入员工名">
                    </td>
                </tr>
                <tr>
                    <td><label for="email">邮箱</label></td>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="e_email" id="email" placeholder="请输入邮箱">
                    </td>
                </tr>
                <tr>
                    <td><label for="department">部门</label></td>
                </tr>
                <tr>
                    <td>
                        <select name="department" id="department">
                            <option value="" selected>--请选择部门--</option>
                            <c:forEach items="${departments}" var="department">
                                <option value="${department.d_id}">${department.d_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="添加" class="submit">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>

</html>
</body>
</html>
