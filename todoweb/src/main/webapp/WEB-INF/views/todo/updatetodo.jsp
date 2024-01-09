<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo 상세</title>
</head>
 <body>
  <div class="container-fluid">
   <jsp:include page="../layout/header.jsp"></jsp:include>
     <!-- 본문영역 -->
	  <div class="row content">
	    <div class="col">
		   <div class="card">
			   <div class="card-body">
				  
				   <form action="/todo/update" method="post">
				    <div class="input-group mb-3">
				         <span class="input-group-text">번호</span>
				         <input type="text" class="form-control" name="tno" placeholder="title"
				          value="${todo.tno}" readonly>
				       </div>
				   
				       <div class="input-group mb-3">
				         <span class="input-group-text">할 일</span>
				         <input type="text" class="form-control" name="title" placeholder="title"
				          value="${todo.title}" >
				       </div>
				     
				       <div class="input-group mb-3">
				        <span class="input-group-text">작성자</span>
				         <input type="text" class="form-control" name="writer" placeholder="writer"
				          value="${todo.writer}" >
				       </div>
				      		<div class="my-4">
				      		<div class="float-end">
				      		<button type="submit" class="btn btn-primary">수정</button>
				      		<button type="button" class="btn btn-danger"
				      		 onclick="return confirm('정말로삭제하시겠어요?')">삭제</button>
				      		
				      		<button type="button" class="btn btn-secondary">목록</button>
				      			
				      		
				      	</div>
				    </div>	
				    </form>	     
				    			       				    				 
			     </div>
			   </div>
		   </div>
	   </div> <!-- 본문영역 -->
     <jsp:include page="../layout/footer.jsp"></jsp:include>
   </div>
   <!-- 자바스크립트영역 -->
   <script>
   let tno = '${todo.tno}';
   let listbtn = document.querySelector(".btn-secondary");
   listbtn.addEventListener("click",function(e){
  	 location.href = "/todo/list";
   });
   
   let deletebtn = document.querySelector(".btn-danger");
   deletebtn.addEventListener("click",function(e){
  	 location.href = "/todo/delete?tno="+tno;
   });
     
   </script>
 </body>
</html>








