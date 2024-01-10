<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax-study</title>
<style>
   .content{margin-left:30px;}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
   <h2>Postdto요청</h2>
   <p><button type="button" onclick="myfunction()">전송</button></p>
   </div>
   <script>
   //ajax는 제이쿼리 라이브러리를 임포트해야함
   //ajax 함수는 객체로 구성되고 형태는-{key:value}임
     const myfunction = function(){
    	// alert("test...");
    	let greet1 = "hi";
    	let number = 1004;
    	$.ajax({
    		//요청방식:GET, 요청주소: /ex01, (함수)-성공,실패
    		//자바스크립트객체-키값을 문자열로 해야함 ex)"greet"(따옴표생략가능)
    		type:"POST",
    		url:"/ex04",
    		data:{greet:greet1,
    			   	"num":number
    			},
    		success:function(res){ //res는 서버에서 보내주는 자료
    			console.log("성공",res);
  		 
    		},
    		error: function(){
    			console.log("실패");
    		}
    	});
     }
   </script>
</body>
</html>