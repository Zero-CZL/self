<%--
  Created by IntelliJ IDEA.
  User: 22944
  Date: 2024/7/31
  Time: 上午11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<center>
    <h1>注册</h1>
    <form id="f1" action="${pageContext.request.contextPath}/servlet/register" method="post" enctype="application/x-www-form-urlencoded">
        用户名:<input type="text" name="username" id="un">
        <span id="s1"></span><br>
        密码:<input type="password" name="password" id="pwd">
        <span id="s2"></span><br>
        确认密码:<input type="password" name="password" id="repwd">
        <span id="s3"></span><br>
        地址:
        <select id="sheng" name="sheng">

        </select>
        <select id="shi" name="shi">

        </select><Br/>
        <input type="submit" value="register">
    </form>
</center>

</body>
<script src="../static/bootstrap-4.6.2-dist/js/jquery-2.2.3.min.js"></script>
<script>
    var flage1=false;
    var flage2=false;
    var flage3=false;

    $("#un").blur(function () {
        var username = $(this).val();
        if (username == null || username.trim() == "") {
            $("#s1").text("用户名不能为空")
            flage1=false;
        } else {
            $.get("${pageContext.request.contextPath}/servlet/check", {username: username}, function (data) {
                if (data == "OK") {
                    $("#s1").text("√")
                    flage1=true;
                } else {
                    $("#s1").text("用户名已存在")
                    flage1=false;
                }
            })
        }
    })

    $("#pwd").blur(function () {
        var password = $(this).val();
        if (password == null || password.trim() == "") {
            $("#s2").text("密码不能为空")
            flage2=false
        } else {
            if (password.length>=6){
                    $("#s2").text("√")
                    flage2 = true
                } else {
                    $("#s2").text("密码长度不能小于6位")
                    flage2 = false
                }
            }
    })

    $("#repwd").blur(function () {
        var repassword = $(this).val();
        var password = $("#pwd").val();
        if (repassword == null || repassword.trim() == "") {
            $("#s3").text("确认密码不能为空")
            flage3=false
        } else {
            if (password==repassword){
                $("#s3").text("√")
                flage3 = true
            } else {
                $("#s3").text("密码不一致")
                flage3 = false
            }
        }
    })

    $("#f1").submit(function () {
        if (flage1&&flage2&&flage3){
            return true
        }else {
            alert("输入项有问题，请检查")
            return false;
        }
    })

    $.get("${pageContext.request.contextPath}/servlet/findCity", {pid: 10000000}, function (data) {
        var shengList = eval("(" + data + ")");
        for (var i = 0; i < shengList.length; i++) {
            $("#sheng").append("<option value='" + shengList[i].name + "'>" + shengList[i].name + "</option>")
        }
    })

    $("#sheng").change(function () {
        $("#shi").text("")

        var shengName = $("#sheng option:selected").val();
        $.post("${pageContext.request.contextPath}/servlet/findCity", {name: shengName}, function (data) {
            var cityList = eval("(" + data + ")");
            for (var i = 0; i < cityList.length; i++) {
                $("#shi").append("<option value='" + cityList[i].name + "'>" + cityList[i].name + "</option>")
            }
        })
    })
</script>
</html>
