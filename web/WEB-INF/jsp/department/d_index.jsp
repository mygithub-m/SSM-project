<%--
  Created by IntelliJ IDEA.
  User: 滑翔的人儿
  Date: 2020/7/20
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>主界面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/d_index.css">
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
    <!-- <script src="../js/Bounce.js"></script> -->
</head>

<body>
<!-- 欢迎登录 -->
<!-- <div class="bounce">欢迎您，尊敬的龟儿子</div> -->
<div class="container">
    <!-- 左边边栏开始 -->
    <div class="sidebar_left">
        <div class="logo">
            <div><a href="${pageContext.request.contextPath}/department/index"  class="option1">部门</a></div>
            <div ><a href="${pageContext.request.contextPath}/employee/index" class="option2">员工</a></div>
        </div>
        <div class="menu">
            <div><a href="${pageContext.request.contextPath}/department/list" class="box1 selected">部门列表</a></div>
            <!-- <div><a href="xxx.html"  class="box1">添加员工</a></div> -->
        </div>
    </div>
    <!-- 左边边栏结束 -->
    <!-- 头部开始 -->
    <div class="sidebar_top">
        <div class="exitLogin">
            <a href="${pageContext.request.contextPath}/manager/exitLogin"> 退出登录</a>
        </div>
    </div>
    <!-- 头部结束 -->

    <!-- 页面展示区开始 -->
    <div class="page">
        <iframe src="${pageContext.request.contextPath}/department/list" frameborder="0" width="100%" height="100%" scrolling=no marginWidth="0"
                marginHeight="0"></iframe>
    </div>
    <!-- 页面展示区结束 -->
</div>
</body>

</html>
