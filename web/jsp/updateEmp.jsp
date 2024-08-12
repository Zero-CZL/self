<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 22944
  Date: 2024/7/30
  Time: 上午11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新</title>
</head>
<body>
<center>
    <h1>编辑员工</h1>
    <form action="${pageContext.request.contextPath}/servlet/updateEmp" method="post" enctype="multipart/form-data">
        <input type="hidden" name="eid" value="${emp.eid}">
        <input type="hidden" name="pageNum" value="${pageNum}">
        <input type="hidden" name="photo" value="${emp.photo}">

        员工姓名：<input type="text" name="ename" value="${emp.ename}"><br/>
        <c:if test="${emp.sex eq '男'}">
        员工性别：
        <input type="radio" name="sex" value="男" checked>🚹
        <input type="radio" name="sex" value="女">🚺<br/>
        </c:if>
        <c:if test="${emp.sex eq '女'}">
            员工性别：
            <input type="radio" name="sex" value="男">🚹
            <input type="radio" name="sex" value="女" checked>🚺<br/>
        </c:if>
        员工工资：<input type="text" name="salary" value="${emp.salary}"><br/>
        员工爱好：
        <input type="checkbox" name="hobby" value="篮球">🏀
        <input type="checkbox" name="hobby" value="足球">⚽
        <input type="checkbox" name="hobby" value="羽毛球">🏸
        <input type="checkbox" name="hobby" value=乒乓球>🏓
        <br/>
        员工头像：
        <input type="file" name="file">
        <img src="${pageContext.request.contextPath}/static/img/${emp.photo}" width="100" height="140">
        <br/>
        员工专业：
        <select name="object_id">
            <c:forEach var="object" items="${objectList}">
                <option value="${object.id}" ${emp.object_id==object.id?'selected=selected':''}>${object.oname}</option>
            </c:forEach>
        </select><br/>
        <input type="submit" value="保存">
    </form>
</center>
</body>
<script>
    var cks=document.getElementsByName("hobby")
    var hobby='${emp.hobby}'
    hobby= hobby.split(",")

    for (var i=0;i<cks.length;i++) {
        for (var j = 0; j < hobby.length; j++) {
            if (cks[i].value == hobby[j]) {
                cks[i].checked = true
            }
        }
    }
</script>
</html>
