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
<h1>글상세</h1>
   <div>
    <table>
    <thead>
      <tr>
      <th>번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>내용</th>
      <th>작성일</th>
      </tr>
    </thead>
    <tbody>
   <tr>
     <th>${board.id}</th>
     <th>${board.btitle}</th>
     <th>${board.bwriter}</th>
     <th>${board.bcontent}</th>
     <th>${board.createdDate}</th>
     </tr>
    
    </tbody>
    
    </table>
   </div>
   <a href="/board/delete?id=${board.id}"   onclick="return confirm('정말로 삭제하시겠습니까?')">글삭제</a>
   <a href="/board/update?id=${board.id}">글수정</a>
   <a href="/">메인으로</a>

</body>
</html>