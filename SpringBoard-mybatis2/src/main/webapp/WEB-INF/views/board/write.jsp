<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기폼</title>
</head>
<body>
   <div id="content">
		<h2>글쓰기</h2>
		<form action="/board/write" method="post">
			<table class="tbl_join">
				<tr>
					<td>
						<label>글제목</label>
						<input type="text" name="boardtitle" >
					</td>
				</tr>
				<tr>
					<td>
						<label>내용</label>
						<textarea rows="3" cols="11" name="boardcontent"></textarea>
					</td>				
				</tr>
				
				<tr>
					<td>
						<label>작성자</label>
						<input type="text" name="boardwriter" value="${sessionid}">
					</td>				
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입">
						<input type="reset" value="취소">
					</td>				
				</tr>				
			</table>		
		
		</form>
	</div>

</body>
</html>