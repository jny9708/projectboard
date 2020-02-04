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
<title>login</title>
</head>
<script>
function loginCheck(){
	var userid = $('input[name=userid]').val();
	var password = $('input[name=password]').val();
	
	if(userid == '' || password == ''){
		alert("아이디 혹은 비밀번호를 입력해주세요.");
		return false;
	}else{
		return true;
	}
}
</script>
<style>
.l-container form {
    height: 400px;
}
</style>
<body>
 <div class="l-container">
	<form method="POST" action="<c:url value="/logincheck"/>" onsubmit="return loginCheck()">
		<div class="input-container">
			<div class="form-group" >  
					<h2>로그인</h2>
				</div>
				<div class="form-group">
					<div class="input-resize">
						<input class="form-control" name="userid" type="text" placeholder="아이디" />
					</div> 
				</div>
				
				<div class="form-group">
					<div class="input-resize">
						<input class="form-control" name="password" type="password" placeholder="비밀번호" />
					</div> 
				</div>
				
				<div class="input-resize">
  					<button type="submit" class="btn btn-primary btn-block" >로그인</button>
  				</div>
  				<div style="margin-top:20px;">
  					<a href="<c:url value="/member/signup"/>" style="align-items: center;">회원가입하기</a>
  				</div>
		</div>
	</form>
</div>
</body>
</html>