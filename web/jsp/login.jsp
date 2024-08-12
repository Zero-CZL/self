<%--
  Created by IntelliJ IDEA.
  User: 22944
  Date: 2024/7/26
  Time: 下午2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="javax.sql.*" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<center>
    <h1>
        登录
    </h1>
    <font color="aqua">${msg}</font>
    <font color="aqua">${msg2}</font>
    <form action="${pageContext.request.contextPath}/servlet/login"method="post">
        用户名:<input type="text" name="username"><br/>
        密码:<input type="password" name="password"><br/>
        <input type="submit" value="login">
<input type="button" value="没有账号？注册一个" id="add">

    </form>
</center>
</body>
<script src="${pageContext.request.contextPath}../static/bootstrap-4.6.2-dist/js/jquery-2.2.3.min.js"></script>
<script>
    $("#add").click(function () {
        window.location.href="${pageContext.request.contextPath}/jsp/register.jsp";

    })
</script>
</html>
