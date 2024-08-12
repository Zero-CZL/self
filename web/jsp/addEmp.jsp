<%--
  Created by IntelliJ IDEA.
  User: 22944
  Date: 2024/7/29
  Time: 下午3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
    <center>
        <h1>添加员工</h1>
        <form action="${pageContext.request.contextPath}/servlet/addEmp" method="post" enctype="multipart/form-data">
            员工姓名：<input type="text" name="ename"><br/>
            员工性别：
            <input type="radio" name="sex" value="男">🚹
            <input type="radio" name="sex" value="女">🚺<br/>
            员工工资：<input type="text" name="salary"><br/>
            员工爱好：
            <input type="checkbox" name="hobby" value="篮球">🏀
            <input type="checkbox" name="hobby" value="足球">⚽
            <input type="checkbox" name="hobby" value="羽毛球">🏸
            <input type="checkbox" name="hobby" value=乒乓球>🏓
            <br/>
            员工头像：
            <input type="file" name="file"><br/>
            员工专业：
            <select name="object_id">
                <c:forEach var="object" items="${objectList}">
                    <option value="${object.id}">${object.oname}</option>
                </c:forEach>
            </select><br/>
            <input type="submit" value="保存">
        </form>
    </center>
</body>
</html>
