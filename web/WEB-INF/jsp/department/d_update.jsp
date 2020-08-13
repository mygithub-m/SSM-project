<%--
  Created by IntelliJ IDEA.
  User: 滑翔的人儿
  Date: 2020/7/20
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改部门</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/update.css">
</head>

<body>
<div class="container">
    <div class="top">
        <div class="path">
            <p>当前位置：<a href="${pageContext.request.contextPath}/department/list">部门列表</a>>><a href="${pageContext.request.contextPath}/department/updateDepPage" class="current">修改部门</a></p>
        </div>
    </div>

    <div class="form">
        <form action="${pageContext.request.contextPath}/department/${department.d_id}" method="post">
            <input type="hidden" name="_method" value="put">
            <table>
                <tr>
                    <td><label for="department">部门</label></td>
                </tr>
                <tr>
                    <td><input type="text" value="${department.d_name}" name="d_name" id="department"></td>
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