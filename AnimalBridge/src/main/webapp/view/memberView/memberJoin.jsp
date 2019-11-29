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
		
		<style type="text/css">
			body {
				width: 900px;
				height: 100vh;
				
				margin: 0 auto;
			
				display: flex;
				justify-content: center;
				align-items: center;
			}
			
			form {
				width: 400px;
				display: flex;
				flex-flow: row wrap;
				justify-content: center;
				
				border: 2px solid black;
				border-radius: 5%;
				
				padding: 30px 0 15px 0;
			}
			
			form div ~ div {
				margin-top: 20px;
			}
			
			form input {
				margin-top: 20px;
			}
			
			form div span {
				display: inline-block;
				width: 120px;
				line-height: 30px;
			}
			
			form div:last-child {
				margin-bottom: 20px;
				width: 100%;
				display: flex;
				justify-content: center;
			}
			
			
			
			form div div span ~ * {
				margin: 10px 10px 0 0;
			}
		</style>
	</head>

	<body>
		<form action="memberJoin.do" method="POST">
			<div>
				<span>이메일 : </span>
				<input type="email" name="email"/>
			</div>
			<div>
				<span>이름 : </span>
				<input type="text" name="name"/>
			</div>
			<div>
				<span>닉네임 : </span>
				<input type="text" name="nickName"/>
			</div>
			<div>
				<span>비밀번호 : </span>
				<input type="password" name="password"/>
			</div>
			<div>
				<span>비밀번호 확인 : </span>
				<input type="password" name="passwordCheck"/>
			</div>
			<div>
				<span>휴대폰 : </span>
				<input type="text" name="phone"/>
			</div>
			<div>
				<span>주소 : </span>
				<input type="text" name="addr"/>
			</div>
			
			<div>
				<div>
					<span>회원 등급</span>
					
					<input type="radio" name="centerIdx" value="0">
					<label>일반회원</label>
					
					<input type="radio" name="centerIdx" value="1"/>
					<label>보호소</label>
					
					<input type="radio" name="centerIdx" value="2"/>
					<label>보호사</label>
				</div>
			</div>
			<div>
				<input type="submit" value="회원가입"/>
				<input type="reset" value="초기화"/>
			</div>
		</form>
	</body>
</html>