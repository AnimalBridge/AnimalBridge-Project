<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<h3>로그인 결과</h3>
		<%
		if(session.getAttribute("memberLogIn") != null) {
		%>
			<p>어서오세요 "${memberLogIn.nickName}"님</p>
			
			<hr/>
			
			<h3>로그인 정보</h3>
			<p>Nick Name : ${memberLogIn.nickName}</p>
			<p>Email : ${memberLogIn.email}</p>
			<p>Password : ${memberLogIn.password}</p>
			<p>Addr : ${memberLogIn.addr}</p>
			<p>Phone : ${memberLogIn.phone}</p>
			
		<% } else { %>
			${error}
		<% } %>
		
		<br/>
		
		<a href="/AnimalBridge/view/index.jsp">홈으로</a>
	</body>
</html>