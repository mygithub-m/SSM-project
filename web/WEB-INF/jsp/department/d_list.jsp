<%--
  Created by IntelliJ IDEA.
  User: 滑翔的人儿
  Date: 2020/7/20
  Time: 17:16
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
    <link rel="stylesheet" href="../css/d_list.css">
    <script src="../js//list.js"></script>
    <script src="../js/d_list.js"></script>
    <script src="../js/fade.js"></script>
    <script src="../js/jQuery.js"></script>

    <script>
        $(function () {
           let alls = $(".allEmployee");
           let d_name = $("#d_name");
           let table = $(".e_table .list table");
           console.log(table);
           alls.click(function () {
               let url = this.href;
               //发送异步请求
               $.get(url,{},function (data) {
                   d_name.html(data[0].department.d_name);
                   let str = " <tr><td>&ensp;序号</td><td>姓名</td><td>邮箱</td></tr>";
                   for (let i = 0; i < data.length; i++) {
                       str += " <tr><td>&ensp;"+i+"</td><td>"+data[i].e_name+"</td><td>"+data[i].e_email+"</td></tr>";
                   }
                   table.html(str);
               });
               return false;
           });
        });
    </script>
</head>

<body>
<div class="container">
    <div class="top">
        <div class="path">
            <p>当前位置：<a href="${pageContext.request.contextPath}/department/list" class="current">部门列表</a></p>
        </div>
        <div class="add">
            <a href="${pageContext.request.contextPath}/department/addDepartmentPage">添加部门<img src="../img/add.png" alt=""></a>
        </div>
    </div>
    <div class="d_table">
        <table cellspacing="0">
            <tr>
                <td>&ensp;ID</td>
                <td>部门名称</td>
                <td style="width: 230px;">操作</td>
            </tr>
            <c:forEach items="${departments}" var="department">
                <tr>
                    <td>&ensp;${department.d_id}</td>
                    <td>${department.d_name}</td>
                    <td class="caozuo"><a href="${pageContext.request.contextPath}/department/updateDepPage/${department.d_id}" class="update">修改&nbsp;<img src="../img/update.png"
                                                                                           alt=""></a>&ensp;
                        <a href="${pageContext.request.contextPath}/department/${department.d_id}" class="delete">删除&nbsp;<img src="../img/delete.png" alt=""></a>
                        <a href="${pageContext.request.contextPath}/department/all/${department.d_id}" class="allEmployee">所有员工</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="" method="post" id="form">
            <input type="hidden" name="_method" value="delete">
        </form>
    </div>

    <div class="e_table">
        <div class="list">
            <div class="list_top">
                <span id="d_name"></span> <span class="close">✖</span>
            </div>
            <table>
                <tr>
                    <td>&ensp;ID</td>
                    <td>姓名</td>
                    <td>邮箱</td>
                </tr>
                <c:forEach items="${employees}" var="employee" varStatus="index">
                    <tr>
                        <td>&ensp;${index.index}</td>
                        <td>${employee.e_name}</td>
                        <td>${employee.e_email}</td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>
</body>

</html>