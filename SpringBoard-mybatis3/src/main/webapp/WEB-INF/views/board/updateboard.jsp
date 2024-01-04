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
		<h2>글수정하기</h2>
			<form action="/board/update" method="post" >
			<input type="hidden" name="id" value="${board.id}">
		<table class="tbl_write">
			<tr>
				<td>
				   <input type="text" name="boardTitle"
				  value="${board.boardTitle}" >
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
				 name="boardContent" >${board.boardContent}</textarea>
				</td>
			</tr>
			<tr>
				<td>
				조회수:${board.hit}
				</td>
			</tr>
			<tr>
				<td>
				작성일:<fmt:formatDate value="${board.updatedTime}"
			        pattern="yyyy-mm-dd HH:mm:ss"/>
				</td>
			</tr>
			
		
				<button type="submit">수정하기</button>
				
							
			<a href="/board/"><button>게시글목록</button></a> 
			
		</table>
		</form>
	</section>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
</body>
</html>