<%--
  Created by IntelliJ IDEA.
  User: 滑翔的人儿
  Date: 2020/7/20
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>员工列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/list.css">
    <script src="${pageContext.request.contextPath}/js/list.js"></script>
</head>

<body>
<div class="container">
    <div class="top">
        <div class="path">
            <p>当前位置：<a href="${pageContext.request.contextPath}/employee/list" class="current">员工列表</a></p>
        </div>
        <div class="add">
            <a href="${pageContext.request.contextPath}/employee/addEmployeePage">添加员工<img src="../img/add.png" alt=""></a>
        </div>
    </div>
    <div class="table">
        <table cellspacing="0">
            <tr>
                <td>&ensp;ID</td>
                <td>姓名</td>
                <td>邮箱</td>
                <td>部门</td>
                <td>操作</td>
            </tr>

            <c:forEach items="${employees}" var="employee" varStatus="i" step="1" begin="0">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${employee.e_name}</td>
                    <td>${employee.e_email}</td>
                    <td>${employee.department.d_name}</td>
                    <td class="caozuo"><a href="${pageContext.request.contextPath}/employee/update/${employee.e_id}" class="update">修改&nbsp;<img src="../img/update.png" alt=""></a>&ensp;
                        <a href="${pageContext.request.contextPath}/employee/${employee.e_id}" class="delete">删除&nbsp;<img src="../img/delete.png" alt=""></a></td>
                </tr>
            </c:forEach>
        </table>

        <form action="" method="post" id="form">
            <input type="hidden" name="_method" value="delete">
        </form>
    </div>
</div>
</body>

</html>
