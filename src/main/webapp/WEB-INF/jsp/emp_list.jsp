<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>工资</th>
			<th>级别</th>
			<th>入职时间</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${emps }" var="emp">
		<tr>
			<td>${emp.empno }</td>
			<td>${emp.ename }</td>
			<td>${emp.sal }</td>
			<td>${emp.deptno eq 1 ? "董事会" : "新人" }</td>
			<td><fmt:formatDate value="${emp.hiredate }" pattern="yyyy-MM-dd"/></td>
			<td>
				<a href="${pageContext.request.contextPath }/emp/detail.do?empno=${emp.empno }">修改</a>
				<a href="${pageContext.request.contextPath }/emp/delete.do?empno=${emp.empno }">修改</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>