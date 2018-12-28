<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/23 0023
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en" class="no-js">

<head>
    <meta charset="utf-8">
    <title>Fullscreen Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
    <link rel="stylesheet" href="assets/css/reset.css">
    <link rel="stylesheet" href="assets/css/supersized.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body>

<div class="page-container">
    <h1>恢复登陆</h1>
    <form method="post" action="/userInfoService">
        <input type="text" name="vocationalWorkType" style="display: none" value="lock">
        <input type="password" name="password" class="password" placeholder="在此输入密码">
        <c:if test="${sessionScope.get('lockStatus') == 'passwordError'}">
            <span><font color="#a9a9a9">解锁失败，请重新输入正确的密码</font></span>
        </c:if>
        <button type="submit">解锁</button>
    </form>
</div>


<!-- Javascript -->
<script src="assets/js/jquery-1.8.2.min.js"></script>
<script src="assets/js/supersized.3.2.7.min.js"></script>
<script src="assets/js/supersized-init.js"></script>
<script src="assets/js/scripts.js"></script>
</body>
</html>

