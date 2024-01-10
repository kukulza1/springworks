<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>members</title>

</head>
<body>
 <h2>${sessionemail}님 환영합니다.</h2>
 <h4><button type="button" onclick="update()">내정보</button></h4>
 <h4><button type="button" onclick="logout()">로그아웃</button></h4>
 <h4><button type="button" onclick="index()">Home</button></h4>
 
 <script>
 let index = function(){
	 location.href="/";
 }
 let logout = function(){
	 location.href="/member/logout";
 }
 </script>
</body>
</html>