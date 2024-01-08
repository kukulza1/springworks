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
	<section id="boardview">
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
				<a href="/board/paging?page=${page}"><button>게시글목록</button></a> 		
		</table>
		
		<!-- 댓글영역 -->
		
		<c:if test="${not empty sessionId}">
		<h3>댓글작성</h3>
		<form action="/reply/insert" method="post" id="replyform" name="replyform">	
		 <input type="hidden" name="boardId" value="${board.id}">
		     <p> <input type="hidden" name="replyer" value="${sessionId}"> 작성자:${sessionId}</p>
		     
		     <p>
		     <textarea rows="2" cols="50" placeholder="댓글작성"
		      id="replyContent" name="replyContent"></textarea>
		     </p>
		     <button type="button" value="등록" onclick="checkreply()">댓글등록</button>
		    </form>
		  </c:if>
		  
		  <c:if test="${empty sessionId}">
		   <div class="replylogin">
		     <a href="/user/login"><i class="fa-solid fa-user"></i>로그인한 사용자만 댓글등록이 가능합니다.</a>
		    </div>
		  </c:if>
		  
		  <h5>댓글목록</h5>
		  <c:forEach items="${replyList}" var="reply">
		
		  <div class="reply">	 
		   작성자:${reply.replyer}  		    
		    <c:choose>
			  <c:when test="${not empty reply.updatedTime}">
			  (수정일:<fmt:formatDate value="${reply.updatedTime}"
			        pattern="yyyy-mm-dd HH:mm:ss"/>)
			  </c:when>  
			  <c:otherwise>			  
				(작성일:<fmt:formatDate value="${reply.createdTime}"
			        pattern="yyyy-mm-dd HH:mm:ss"/>)				
			  </c:otherwise>
			   </c:choose>	
			   
			   <c:if test="${sessionId eq reply.replyer}">			   		    		             
		       <a href="/reply/update?boardId=${board.id}&id=${reply.id}">수정</a> |
		       <a href="/reply/delete?boardId=${reply.boardId}&id=${reply.id}" 
		       onclick="confirm('정말로 삭제하시겠습니까?')">삭제</a>
		       </c:if>
		    <p>댓글내용:${reply.replyContent}</p>		    
		  </div>
		  </c:forEach>
		
		
	</section>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
	
	<script>
	 const checkreply = function(){
		// alert("댓글등록");
		let content = document.getElementById("replyContent");
		if(content.value == ""){
			alert("댓글을 입력해주세요");
			content.focus();
			return false;
		}else{
		 document.replyform.submit();
		}			 
	 }
	</script>
</body>
</html>











