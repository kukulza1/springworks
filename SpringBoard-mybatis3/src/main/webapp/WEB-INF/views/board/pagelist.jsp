<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
</head>
<body>
  <jsp:include page="../layout/header.jsp"/>
	<div id="container">
	<section id="boardlist">
		<h2>글목록</h2>
		<table class="tbl_list">
		<thead>
		<tr>
		  <td>글번호</td>
		  <td>글제목</td>
		  <td>글쓴이</td>
		  <td>작성일</td>
		  <td>조회수</td>
		</tr>
			</thead>
			<tbody>
			   <c:forEach items="${boardlist}" var="board">
			     <tr>
			       <td>${board.id}</td>		      
 <td><a href="/board?id=${board.id}&page=${paging.page}">${board.boardTitle}</a></td>
			       <td>${board.userId}</td>	
			       		       
			       <td><fmt:formatDate value="${board.updatedTime}"
			        pattern="yyyy-mm-dd HH:mm:ss"/> </td>
			       <td>${board.hit}</td>
			     </tr>
			   </c:forEach>
			</tbody>
		</table>
		
		<!-- 페이지 처리 영역 -->
		<div class="pagination">
		<c:choose>
		<c:when test="${paging.page <=1 }">
		<span>[이전]</span>
		</c:when>
		<c:otherwise>
		<a href="/board/paging?page=${paging.page-1}">[이전]</a>
		</c:otherwise>	
		</c:choose>
		
		<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
		 <c:choose>
		   <c:when test="${paging.page eq i}">
		       <span class="current_page">${i}</span>
		   </c:when>
		   <c:otherwise>
		    <a href="/board/paging?page=${i}">${i}</a> 	
		   </c:otherwise>
		 </c:choose>
		
		 	
		</c:forEach>
		
		<c:choose>
		<c:when test="${paging.page >= paging.maxPage }">
		<span>[다음]</span>
		</c:when>
		<c:otherwise>
		<a href="/board/paging?page=${paging.page+1}">[다음]</a>
		</c:otherwise>	
		</c:choose>
		</div>
		
		<li><a href="/board/write">글쓰기</a></li>
		</section>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
</body>
</html>