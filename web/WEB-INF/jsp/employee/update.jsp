<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 滑翔的人儿
  Date: 2020/7/20
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改用户</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/update.css">
</head>

<body>
<div class="container">
    <div class="top">
        <div class="path">
            <p>当前位置：<a href="${pageContext.request.contextPath}/employee/list">员工列表</a>>><a href="${pageContext.request.contextPath}/employee/update/${employee.e_id}" class="current">修改员工</a></p>
        </div>
    </div>

    <div class="form">
        <form action="${pageContext.request.contextPath}/employee/${employee.e_id}" method="post">
            <input type="hidden" name="_method" value="put">
            <input type="hidden" name="e_id" value="${employee.e_id}">
            <table>
                <tr>
                    <td><label for="name">姓名</label></td>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="e_name" id="name" value="${employee.e_name}">
                    </td>
                </tr>
                <tr>
                    <td><label for="email">邮箱</label></td>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="e_email" id="email" value="${employee.e_email}">
                    </td>
                </tr>
                <tr>
                    <td><label for="department">部门</label></td>
                </tr>
                <tr>
                    <td>
                        <select name="did" id="department">
                            <c:forEach items="${departments}" var="department">
                                <c:if test="${employee.department.d_id == department.d_id}">
                                    <option value="${department.d_id}" selected>${department.d_name}</option>
                                </c:if>
                                <c:if test="${employee.department.d_id != department.d_id}">
                                    <option value="${department.d_id}">${department.d_name}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="修改" class="submit">
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
