<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<h3>회원가입 결과</h3>
		
		<c:choose>
			<c:when test="${empty memberLogIn}">
				<p>${error}</p>
			</c:when>
		
			<c:otherwise>
				<p>${memberLogIn} 님, 회원가입을 축하 드립니다.
			</c:otherwise>
		</c:choose>
		
		<br/>
		
		<a href="../index.jsp">홈으로</a>
	</body>
</html>