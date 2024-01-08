<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo 등록</title>
</head>
 <body>
  <div class="container-fluid">
   <jsp:include page="../layout/header.jsp"></jsp:include>
     <!-- 본문영역 -->
	  <div class="row content">
	    <div class="col">
		   <div class="card">
			   <div class="card-body">
				   <form action="/todo/register" method="post">
				       <div class="input-group mb-3">
				         <span class="input-group-text">할 일</span>
				         <input type="text" class="form-control" name="title" placeholder="title">
				       </div>
				     
				       <div class="input-group mb-3">
				        <span class="input-group-text">작성자</span>
				         <input type="text" class="form-control" name="writer" placeholder="writer">
				       </div>
				      				     
				        <p>
					      <input type="submit"  class="btn btn-success" value="등록">
					      <input type="reset" class="btn btn-secondary" value="취소">
				        </p>
				    
				   </form>
			     </div>
			   </div>
		   </div>
	   </div> <!-- 본문영역 -->
     <jsp:include page="../layout/footer.jsp"></jsp:include>
   </div>
 </body>
</html>