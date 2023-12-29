<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세보기</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="content">
		<h2>글상세보기</h2>
		
		<table>
			<tr>
				<td>
					<label>글제목</label>
					<input type="text" name="boardTitle" value="${board.boardTitle }" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<label>글쓴이</label>
					<input type="text" name="boardWriter" value="${board.boardWriter }" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<label>작성일</label>
					<input type="text" name="boardWriter" value="${board.createTime }" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<label>글내용</label>
					<textarea rows="5" cols="50" name="boardContent" readonly>${board.boardContent}</textarea>
				</td>
			</tr>	
			<tr>
				<a href="/board/list">목록으로</a>
			</tr>
		</table>
		
	</div>
</body>
</html>