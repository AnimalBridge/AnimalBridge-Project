<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title></title>
		
		<style>
			* {
				margin: 0;
				padding: 0;
			}
			
			body {
				height: 50vh;
			
				display: flex;
				flex-flow: row wrap;
				justify-content: center;
				align-items: center;
			}
			
			.wrap {
				margin: 0 auto;
			
				width: 400px;
				padding: 30px;
				
				border: 3px solid black;
			}
			
			.wrap div {
				width: 100%;
				height: 30px;
			}
			
			.wrap div:nth-child(1) {
				text-align: center;
			}
			
			.wrap div  {
				display: flex;
				justify-content: center;
				margin-top: 30px;
			}
			
			input[type="password"] {
				margin-left: 20px;
			}
			
		</style>
	</head>

	<body>
		<div class="wrap">
			<div>탈퇴 하시겠습니까?</div>
			
			<form action="memberLeave.do">
				<div>
					Password : <input type="password" name="password"/>
				</div>
				<div>
					<input type="submit" value="탈퇴"/>
				</div>
			</form>
		</div>
	</body>
</html>