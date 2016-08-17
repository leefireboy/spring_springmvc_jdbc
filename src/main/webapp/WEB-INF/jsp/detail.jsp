<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工详情</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/emp/update.do" method="post">
		<input type="text" value="${emp.ename }" name="ename"><br/>
		<input type="text" value="${emp.job }" name="job"><br/>
		<input type="text" value="${emp.mgr }" name="mgr"><br/>
		<input type="text" value="${emp.hiredate }" name="hiredate"><br/>
		<input type="text" value="${emp.sal }" name="sal"><br/>
		<input type="text" value="${emp.comm }" name="comm"><br/>
		<input type="text" value="${emp.deptno }" name="deptno"><br/>
		<input type="hidden" value="${emp.empno }" name="empno"><br/>
		<input type="submit" value="修改">
	</form>
</body>
</html>