<%--
  Created by IntelliJ IDEA.
  User: 滑翔的人儿
  Date: 2020/7/20
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加部门</title>
    <link rel="stylesheet" href="../css/add.css">
    <script src="../js/add.js"></script>
</head>
<body>
<div class="container">
    <div class="top">
        <div class="path">
            <p>当前位置：<a href="${pageContext.request.contextPath}/department/list">部门列表</a>>><a href="${pageContext.request.contextPath}/department/addDepartmentPage" class="current">添加部门</a></p>
        </div>
    </div>

    <div class="form">
        <form action="${pageContext.request.contextPath}/department/add" method="post">
            <table>
                <tr>
                    <td><label for="department">部门</label></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="请输入门名称" name="d_name" id="department"></td>
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
