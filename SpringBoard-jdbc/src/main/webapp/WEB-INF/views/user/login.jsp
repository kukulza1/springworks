<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="/user/login" method="post">
		<p>
			<label>아이디</label>
			<input type="text" name="userid" >
		</p>
		<p>
			<label>비번</label>
			<input type="password" name="userpasswd" >
		</p>
		
		<p><input type="submit" value="가입하기"></p>
	</form>
</body>
</html>