<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
  <h1>글쓰기</h1>
  <form action="/board/write" method="post">
    <p><input type="text" name="btitle" placeholder="제목"></p>
    <p><input type="text" name="bwriter" placeholder="작성자"></p>
    <p><textarea rows="4" cols="60" name="bcontent" placeholder="내용"></textarea></p>
    <p><input type="submit" value="등록">
    <input type="reset" value="취소"></p>
  </form>
  

</body>
</html>