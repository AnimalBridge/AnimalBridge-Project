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
		<h3>로그인</h3>
		<form action="memberLogIn.do" method="POST">
			Nick Name : <input type="text" name="nickName"/><br/>
			Password : <input type="password" name="password"/><br/>
			<input type="submit" value="로그인"/>
		</form>
		
		
	</body>
</html>