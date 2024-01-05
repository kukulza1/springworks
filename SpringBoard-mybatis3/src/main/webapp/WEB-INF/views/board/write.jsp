<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
<c:if test="${empty sessionId}">
<script>
 alert("로그인후 이용가능합니다");
  location.href = "/user/login";
</script>
</c:if>
<jsp:include page="../layout/header.jsp"/>
	<div id="container">
	<section id="writeform">
		<h2>글쓰기</h2>
		<form action="/board/write" method="post">
		
			<ul>
				<li>
					<input type="text" name="boardTitle" placeholder="글 제목" required>
				</li>
			
				<li>
					<input type="text" name="userId" value="${sessionId}" readonly> 
				</li>
			
				<li>
					<textarea rows="5" cols="50" name="boardContent"
							placeholder="글 내용"></textarea>
				</li>
			
				<li>
					<button type="submit" value="글쓰기">글쓰기</button>
					<a href="/"><button type="reset" value="취소">취소</button></a>
				</li>
			</ul>
	
		</form>
		</section>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
</body>
</html>