<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
          <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글수정</title>
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
	<div id="container">
	<section id="boardvierw">
		<h2>댓글수정하기</h2>
			<form action="/reply/update" method="post" >
			<input type="hidden" name="boardId" value="${reply.boardId}">
			<input type="hidden" name="id" value="${reply.id }">
			<p>작성자:${reply.replyer}  (작성일:<fmt:formatDate value="${reply.createdTime}" 
		       pattern="yyyy-mm-dd HH:mm:ss"/>)</p>				  	     
		    <p><textarea name="replyContent" rows="3" cols="19">${reply.replyContent}</textarea>  </p>
		    	
		    <p>
		     <input type="submit" value="수정하기">
		     <input type="reset" value="취소">
		    </p>	    
		  
		 
		</form>
	</section>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
</body>
</html>