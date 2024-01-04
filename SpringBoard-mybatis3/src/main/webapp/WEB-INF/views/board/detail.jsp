<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
	<div id="container">
	<section id="boardvierw">
		<h2>글상세보기</h2>
			
		<table class="tbl_write">
			<tr>
				<td>
				   <input type="text" name="boardTitle"
				  value="${board.boardTitle}" readonly>
				</td>
			</tr>
			<tr>
				<td>
				<input type="text" name="userId"
				  value="${board.userId}" readonly>
				</td>
			</tr>
			<tr>
				<td>
				<textarea rows="5" cols="60"
				 name="boardContent" readonly>${board.boardContent}</textarea>
				</td>
			</tr>
			<tr>
				<td>
				조회수:${board.hit}
				</td>
			</tr>
			<tr>
			<c:choose>
			  <c:when test="${not empty board.updatedTime}">
			  수정일:<fmt:formatDate value="${board.updatedTime}"
			        pattern="yyyy-mm-dd HH:mm:ss"/>
			  </c:when>
			  
			  <c:otherwise>
			  <td>
				작성일:<fmt:formatDate value="${board.createdTime}"
			        pattern="yyyy-mm-dd HH:mm:ss"/>
				</td>
			  </c:otherwise>
			</c:choose>
			
				
			</tr>
			
			<c:if test="${board.userId  eq sessionId}">
				<a href="/board/update?id=${board.id}"><button>수정</button></a> 
				<a href="/board/delete?id=${board.id}" onclick="return confirm('정말로삭제하시겠습니까?')"><button>삭제</button></a>
				</c:if> 
				<a href="/board/"><button>게시글목록</button></a> 
			
		</table>
		<!--  -->
		<h5>댓글창</h5>
		
		<h5>댓글작성</h5>
		<form action="/reply/insert" method="post" id="replyform">
		<input type="hidden" name="boardId" value="${board.id }">
		  <p>
		  <input type="text" name="replyer" placeholder="댓글작성자"> 
		  </p>
		  <p>
		   <textarea rows="3" cols="50" placeholder="댓글작성"
		   name="replyContent"></textarea>
		  </p>
		  <input type="submit" value="등록">
		</form>
		
	</section>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
</body>
</html>