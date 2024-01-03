<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
	<div id="container">
		<h2>글상세보기</h2>
		
		<table class="tbl_write">
			<tr>
				<td>
					${board.boardTitle}
				</td>
			</tr>
			<tr>
				<td>
				${board.userId}
				</td>
			</tr>
			<tr>
				<td>
				${board.boardContent}
				</td>
			</tr>
			<tr>
				<td>
				${board.hit}
				</td>
			</tr>
			<tr>
				<td>
				${board.createdTime}
				</td>
			</tr>
			<tr>
				<a href="/board/"><button>목록</button></a> 
			</tr>
		</table>
	
	</div>
	<jsp:include page="../layout/footer.jsp"/>
</body>
</html>