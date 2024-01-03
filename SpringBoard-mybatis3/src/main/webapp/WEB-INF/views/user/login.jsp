<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
	<div id="container">
		<h2>로그인</h2>
		<form action="/user/login" method="post">
		<fieldset>
			<ul>
			   <li><label>아이디</label></li>
				<li>
					<input type="text" name="userId" placeholder="아이디">
				</li>
			
			    <li> <label>비밀번호</label></li>
				<li>
					<input type="password" name="userPasswd" placeholder="비밀번호">
				
			</ul>
		</fieldset>
				<div class="button">
					<input type="submit" value="로그인">
					<input type="reset" value="취소">
					</div>
		</form>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
</body>
</html>