<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
</head>
<body>
<h1>글목록</h1>
   <div>
    <table>
    <thead>
      <tr>
      <th>번호</th>
      <th>제목</th>
      <th>작성자</th>     
      <th>작성일</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${boardlist }" var="board">
    <tr>
     <th>${board.id}</th>
     <th><a href="/board?id=${board.id}">${board.btitle}</a></th>
     <th>${board.bwriter}</th>
     <th>${board.createdDate}</th>
     </tr>
     </c:forEach>
    </tbody>
    
    </table>
   </div>
   <a href="/">메인으로</a>

</body>
</html>