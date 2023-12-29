<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 폼...</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="content">
		<h2>글 목록</h2>
		<div>
		
  <c:if test="${not empty sessionid}">
   ${sessionid}님환영합니다
	 <a href="/user/logout">로그아웃</a>
  </c:if>  
		</div>
		<table>
		  <thead>
		   <tr>
		    <th>번호</th>
		    <th>제목</th>
		    <th>글쓴이</th>
		    <th>작성일</th>
		   </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${boardList}" var="board">
		  <tr>
		   <td>${board.id}</td>
		   <td><a href="/board?id=${board.id}"> ${board.boardTitle}</a></td>
		   <td>${board.boardWriter}</td>
		   <td>${board.createTime}</td>
		  </tr>
		  </c:forEach>
		  </tbody>
		</table>
		<a href="/">목록으로</a>
		
		
		
	</div>
</body>
</html>