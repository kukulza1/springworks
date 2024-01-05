<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
	<div id="container">
	<section id="join">
		<h2>회원 정보 수정</h2>
		<form action="/user/update" method="post">
		<input type="hidden" name="id" value="${user.id}">
		<fieldset>
			<ul>
			   <li><label>아이디</label></li>
				<li>
					<input type="text" name="userId" 
					value="${user.userId}" readonly >
				</li>
		
			    <li> <label>비밀번호</label></li>
				<li>
					<input type="password" name="userPasswd" 
					value="${user.userPasswd}">
				</li>
			
			    <li><label>이름</label></li>
				<li>
					<input type="text" name="userName" 
					value="${user.userName}">
				</li>
			
			    <li><label>나이</label></li>
				<li>
					<input type="text" name="userAge" 
					value="${user.userAge}">
				</li>
			
				<li colspan="2">
					<input type="submit" value="수정하기">
				    <input type="reset" value="취소">
				</li>
			</ul>
		</fieldset>
		</form>
		</section>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
	<script>
		const list = function(){
			location.href = "/user/";
		}
	</script>
</body>
</html>