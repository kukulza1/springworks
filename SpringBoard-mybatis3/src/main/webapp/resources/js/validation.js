/**
 * 
 */
 let checkuser = function(){
		  //alert("가입");
		  //아이디는4~15자
		  //비번은 영문자 숫자 특수문자 포함 8자이상입력
		  //이름은 한글만 나이는 숫자만
		  
		  let form = document.userform;
		  
		  let userId = document.getElementById("userId").value;
		  let userAge =document.getElementById("userAge").value;
		  let userName =document.getElementById("userName").value;
		  let userPw =document.getElementById("userPasswd").value;
		  
		  //정규표현식
		  let regName = /^[가-힣]+$/; //한글만
		  
		  let regpw1 =/[0-9]+/;
		  let regpw2 =/[a-zA-Z]+/;
		  let regpw3 =/[~!@#$%^&*()\-=]+/;
		  
		  
		  if(userId.length<4 || userId.length >15){
			   alert("아이디는4~15자까지 입력해주세요");
			   document.getElementById("userId").select();
			   return false;
			  
		  }else if(userPw.length <8 || !regpw1.test(userPw) || !regpw2.test(userPw) ||
				  !regpw3.test(userPw)   ){
			   alert("비밀번호는영문자 숫자 특수문자포함 8자이상 입력해주세요 (-)하이픈사용불가 ");
			   document.getElementById("userPasswd").select();
			   return false;
			   
		  }else if(!regName.test(userName)){ //이름이 정규식과 일치하지않으면
			  alert("이름은 한글만입력해주세요");
			  document.getElementById("userName").select();
			  return false;
			  
		  }else if(isNaN(userAge) || userAge == ""){ //숫자가아니면 비어있다면
			  alert("나이는숫자만입력해주세요");
			  document.getElementById("userAge").select();
			  return false;
			  
		  }else{ 
			  form.submit(); //검사끝나면 폼에 전송
		  }
		  
	  }//checkuser닫기
	   //id중복검사 순서
	   /*
	   1.아이디 입력값가져오기
	   2.입력값을 서버에 전송하고 중복된 아이디가 있는지 확인
	   */
	  
	   let checkid = function(){
		 // alert("중복검사");
		let userid = document.getElementById("userId").value;
		let cr = document.getElementById("check-result");
		console.log(userid);
		if(userid != ""){
		$.ajax({
			//요청방식:post, url: /user/checkuserid, 데이터:userId
			type:"post",
			url:"/user/checkuserid",
			data:{"userId":userid},
		    //서버에서 응답 -성공실패여부
		     success:function(response){
		    	 console.log(response);
		    	 
		    	 if(response == "usable"){
		    		 cr.innerHTML = "사용가능한 아이디 입니다";
		    		 cr.style.color ="blue";
		    	 }
		    	 else{
		    		 cr.innerHTML = "중복된 아이디 입니다";
		    		 cr.style.color ="red";
		    	 }	    	 	    	 
		     },
		     
		     error:function(error){
		    	 console.log("에러발생",error);
		     }
		     
		});
		}
		
	  }