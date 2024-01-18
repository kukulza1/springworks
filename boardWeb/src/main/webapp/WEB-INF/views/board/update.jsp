<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정...</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="content">
		<h2>글 수정</h2>
		<form action="/board/update" method="post">
		<input type="hidden" name="id" value="${board.id}">
			<table class="tbl_write">
				<tr>
					<td>
						<input type="text" name="btitle" 
							value="${board.btitle}">
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="bwriter" 
							value="${board.bwriter}">
					</td>
				</tr>
				<tr>
					<td>
						<textarea rows="5" cols="50" placeholder="글내용" 
							name="bcontent">${board.bcontent}</textarea>
					</td>
				</tr>	
				<tr>
					<td>
						<button type="submit">저장</button>
						<button type="reset">취소</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>