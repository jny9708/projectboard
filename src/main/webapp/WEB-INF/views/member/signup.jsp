<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member.css">
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<title>회원가입</title>
</head>

<script>
	var idCheckUrl = '<c:url value="/idcheck"/>';
	
	var IdClickbool = false;
	var reg_idCheck = false;
	var reg_pwdCheck = false;
	var IdCheckbool = false;
	var passwordCheckbool=false;
	var regExpId = /^[0-9a-z]{1,13}$/;
	

	
	$(function(){
		  $('#btn-idcheck').click(function(){
			reg_idCheck = false;
			IdCheckbool = false;
			IdClickbool = true;
			  
			  var userid = {'userid':$('input[name=userid]').val()};
			  console.log(userid.userid);   
			  if(userid.userid==undefined||userid.userid=='' ){
				  alert("아이디를 입력하세요.");
			  }else{
				  if(regExpId.test(userid.userid)){  
			  			reg_idCheck = true;  
					  $.ajax({
							url: idCheckUrl, 
							data : userid,
							type : 'POST',
							dataType : "json",
							success : function(data){
								console.log(data);
								if(data==true){
									IdCheckbool=true;
									alert("사용해도 되는 아이디입니다.");
								}
							}
						  });
		  		}else{
			  		alert("아이디는 최대 13글자의 영문과 숫자여야합니다.");
			  		reg_idCheck = false;
					IdCheckbool = false;
		  		}
			  }
			  
		    });
		
	
	
	
		  $('#password-check').focusout(function(){
			  
			  if($('input[name=password]').val()!=$('#password-check').val()){
				  alert("두 비밀번호가 서로 일치하지 않습니다.");
				  passwordCheckbool=false;
			  }else{
				  passwordCheckbool=true;
				  var pw = $('#password-check').val();
				  if(pw.length < 8 || pw.length > 15){

					  alert("8자리 ~ 15자리 이내로 입력해주세요.");
					  reg_pwdCheck=false;
					  
					 }else{
						 reg_pwdCheck=true;
					 }
				  
				  
			  }
			  
		  });
		  
		
	});
	
	function submitCheck(){
			if(IdClickbool==true&&reg_idCheck==true&&IdCheckbool==true){
				//console.log("아이디는 확인");
				if(passwordCheckbool==true&&reg_pwdCheck==true){
					//console.log("비밀번호도 확인");
					return true;
				}else{
					alert("비밀번호를 확인해주세요");
					return false;
				}
			}else if(IdClickbool==false){
				alert("아이디 중복확인을 해주세요");
				return false;
			}
			else {
				alert("아이디를 확인해주세요.");
				return false;
			}

		}
		
	//아이디값이 변경되었을 때 검사bool들 다 초기화
	function idchange(){
		IdClickbool = false;
		reg_idCheck = false;
		IdCheckbool = false;
	}
	//비밀번호값이 변경되었을 때 검사bool들 다 초기화
	function pwdchange(){
		passwordCheckbool=false;
		reg_pwdCheck=false;
	}
		
		
			
	
	
	
</script>

<body>

        
    <div class="l-container">
    
		<form method="POST" action="<c:url value="/member/add"/>" onsubmit="return submitCheck()">
		 
			<div class="input-container">
				<div class="form-group" >  
					<h2>회원가입</h2>
				</div>
				<div class="form-group">
					<div class="input-resize">
					<input class="form-control" name="userid" type="text" placeholder="아이디" onchange="idchange()"/>
					</div> 
				</div>
				
				
				<div class="input-resize form-group">   
  					<button type="button" class="btn btn-default btn-block" id="btn-idcheck">아이디 중복확인</button>
  				</div>
				
					<div class="form-group">
					<div class="input-resize">
					<input class="form-control" name="password" type="password" placeholder="비밀번호" onchange="pwdchange()" />
					</div> 
				</div>
			
			
				<div class="form-group">
					<div class="input-resize">
					<input class="form-control" name="password-check" id="password-check" type="password" placeholder="비밀번호 확인" onchange="pwdchange(this)"/>
					</div> 
				</div>
			
				
					<div class="input-resize">
  					<button type="submit" class="btn btn-primary btn-block" >회원가입</button>
  				</div>
  				
			</div> 
			
									
			
			
			 
			 
			 
			
	
		</form>
	</div>
</body>
</html>