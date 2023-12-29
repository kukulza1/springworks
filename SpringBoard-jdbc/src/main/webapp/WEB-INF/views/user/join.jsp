<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 폼</title>
</head>
<body>
	<h2>회원 가입</h2>
	<form action="/user/join" method="post">
		<p>
			<label>아이디</label>
			<input type="text" name="userid" >
		</p>
		<p>
			<label>비번</label>
			<input type="password" name="userpasswd" >
		</p>
		<p>
			<label>이름</label>
			<input type="text" name="username" >
		</p>
		<p>
			<label>나이</label>
			<input type="text" name="userage" >
		</p>
		<p><input type="submit" value="가입하기"></p>
	</form>
</body>
</html>