<%--
  Created by IntelliJ IDEA.
  User: 22944
  Date: 2024/7/26
  Time: 下午4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../static/bootstrap-4.6.2-dist/css/bootstrap.css">
    <title>员工列表</title>
</head>
<body>
<center>
  <h1>员工列表</h1>
  <h2>
    欢迎${sessionScope.user.address}的${sessionScope.user.username}登录
  </h2>
  <form id="f1" action="${pageContext.request.contextPath}/servlet/empShow" method="get">
    <input type="text" name="likeName" value="${likeName}">
    <input type="hidden" name="pageNum" id="pageNum">
    <input type="submit" value="搜索">
    <input type="button" value="添加员工" onclick="toAdd()">
    <input type="button" value="删除选中员工" onclick="del()">
    <input type="button" value="echarts图表" onclick="echarts()">
  </form>
  <table class="table-striped">
    <tr>
      <th>
        <input type="button" value="全选/全不选" onclick="fx();">
      </th>
      <th>员工编号</th>
      <th>员工姓名</th>
      <th>员工性别</th>
      <th>员工工资</th>
      <th>员工爱好</th>
      <th>员工头像</th>
      <th>员工专业</th>
      <th>操作</th>

    </tr>
    <c:forEach var="emp" items="${pageBean.beanList}">
      <tr>
        <td>
          <input type="checkbox" name="cks" value="${emp.eid}">
        </td>
      <td>${emp.eid}</td>
      <td>${emp.ename}</td>
        <td>${emp.sex}</td>
      <td>${emp.salary}</td>
      <td>${emp.hobby}</td>
      <td>
        <img src="${pageContext.request.contextPath}/static/img/${emp.photo}" width="100" height="140">
      </td>
      <td>${emp.oname}</td>
        <td>
          <button onclick="updateEmp(${emp.eid},${pageBean.pageNum})">
            编辑
          </button>
        </td>
      </tr>
    </c:forEach>
  </table>
  当前第${pageBean.pageNum}页/共${pageBean.pages}页 共${pageBean.total}条记录
  <a href="javascript:go(1)">首页</a>

  <c:if test="${pageBean.pageNum>1}">
    <a href="javascript:go(${pageBean.pageNum-1});">上一页</a>
  </c:if>

  <c:choose >
    <c:when test="${pageBean.pages<=10}">
      <c:set var="begin" value="1"></c:set>
      <c:set var="end" value="${pageBean.pages}"></c:set>
    </c:when>
    <c:otherwise>
      <c:set var="begin" value="${pageBean.pageNum-5}"></c:set>
      <c:set var="end" value="${pageBean.pageNum+4}"></c:set>
      <c:if test="${begin<1}">
        <c:set var="begin" value="1"></c:set>
        <c:set var="end" value="10"></c:set>
      </c:if>
      <c:if test="${end>pageBean.pages}">
        <c:set var="begin" value="${pageBean.pages-9}"></c:set>
        <c:set var="end" value="${pageBean.pages}"></c:set>
      </c:if>
    </c:otherwise>
  </c:choose>

  <c:forEach var="i" begin="${begin}" end="${end}">
    <c:choose>
      <c:when test="${pageBean.pageNum eq i}">
        ${i}
      </c:when>
      <c:otherwise>
        <a href="javascript:go(${i});">${i}</a>
      </c:otherwise>
    </c:choose>
  </c:forEach>

  <c:if test="${pageBean.pageNum<pageBean.pages}">
    <a href="javascript:go(${pageBean.pageNum+1});">下一页</a>
  </c:if>

  <a href="javascript:go(${pageBean.pages});">尾页</a>
</center>
</body>
<script>
  function go(pageNum) {

    var page=document.getElementById("pageNum");
    page.value=pageNum;
    var f1 =document.getElementById("f1");
    f1.submit();
  }

  function toAdd(){
    window.location.href="${pageContext.request.contextPath}/servlet/addEmp"
  }

  function updateEmp(eid,pageNum){
    window.location.href="${pageContext.request.contextPath}/servlet/updateEmp?eid="+eid+"&pageNum"+pageNum;
  }
  
  function fx() {
    let cks = document.getElementsByName("cks");
    for (var i=0;i<cks.length;i++){
      if (cks[i].checked){
        cks[i].checked=false;
      }else {
        cks[i].checked=true;
      }
    }
  }

  function del() {
    var count=0;
    var cks=document.getElementsByName("cks");
    for (var i=0;i<cks.length;i++){
      if (cks[i].checked){
        count++
      }
    }
  if (count>0){
    if(confirm("确定要删除吗？")){
      var ids=""
      var cks=document.getElementsByName("cks");
      for (var i=0;i<cks.length;i++){
        if (cks[i].checked){
          ids+=cks[i].value+"-";
        }
      }
      window.location.href="${pageContext.request.contextPath}/servlet/delEmp?ids="+ids;
    }else{
      alert("取消成功")
    }
  }else{
    alert("至少选择一项删除")
  }
  }
  function echarts(){
    window.location.href="${pageContext.request.contextPath}/servlet/echarts";
  }

</script>
</html>
