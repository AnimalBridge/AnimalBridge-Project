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
		<h3>로그인 결과</h3>

		<c:choose>
			<c:when test="${empty memberLogInNickName}">
				<p>${error}</p>
			</c:when>
			
			<c:otherwise>
				<p>어서오세요 "${memberLogInNickName}"님</p>
				<p>등급 : ${memberLogInCenterIdx}</p>
			</c:otherwise>
		</c:choose>
		
		<br/>
		
		<a href="../index.jsp">홈으로</a>
	</body>
</html>