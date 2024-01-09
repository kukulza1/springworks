<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				    <h2>Todo목록</h2>
				    <table class="table">
				     <thead>
				       <tr>
				        <th>번호</th>
				        <th>제목</th>
				        <th>작성자</th>
				       </tr>
				     </thead>
				     <tbody>
				     <c:forEach items="${todolist}" var="todo">
				     <tr>
				      <td>${todo.tno }</td>
				      <td><a href="/todo?tno=${todo.tno}">${todo.title }</a></td>
				      <td>${todo.writer }</td>
				     </tr>
				     </c:forEach>
				     
				     </tbody>
				    </table>
				    
			    </div>
			 </div>
		  </div>
	   </div> <!-- 본문영역 -->
     <jsp:include page="../layout/footer.jsp"></jsp:include>
   </div>
 </body>
</html>