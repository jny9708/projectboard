<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member.css">
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<style>
  body{
        background-color: white;
    }
    .l-container{
        height: auto;
        flex-direction: column;
    }
    h2{
        margin: 60px 0px 60px 0px;
        text-align: center;
    }
    .l-container .t-container{
    width:80%;
    height: auto;
    }
    .l-container .t-container button{
        width: 25%;
    }
    .container{
        padding: 20px;
        
    }
    .identify{
        padding-bottom: 15px;
        margin-bottom: 25px;
        display: flex;
        justify-content: flex-end;
        border-bottom: 1px solid #e6e6e6;
    }

    .identify .plot{
        margin: 0px 20px;
    }
   </style>
   
   <script type="text/javascript">
   $(function(){
	   $('#btnUpdate').click(function(){
		   var url = '<c:url value="/board/modify/"/>'+${boardVO.id};
		   location.href = url;
	   });
	   
	   $('#btnDelete').click(function(){
		   var url = '<c:url value="/board/delete/"/>'+${boardVO.id};
		   location.href = url;
	   });
	   
	   $('#btnList').click(function(){
		   var url = '<c:url value="/"/>';
		   location.href = url;
	   });
   
   });
   		
   </script>
<body>
	<h2>게시글 내용</h2>
    <div class="container">
        <div class="b-container">
      <h3>${boardVO.title}</h3>
            <div class="identify">
                <span>${boardVO.userid}</span>
                <span class="plot"><b>│</b></span>
             	<span>   
                 <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M12.015 7c4.751 0 8.063 3.012 9.504 4.636-1.401 1.837-4.713 5.364-9.504 5.364-4.42 0-7.93-3.536-9.478-5.407 1.493-1.647 4.817-4.593 9.478-4.593zm0-2c-7.569 0-12.015 6.551-12.015 6.551s4.835 7.449 12.015 7.449c7.733 0 11.985-7.449 11.985-7.449s-4.291-6.551-11.985-6.551zm-.015 3c-2.209 0-4 1.792-4 4 0 2.209 1.791 4 4 4s4-1.791 4-4c0-2.208-1.791-4-4-4z"/>
             </svg>
             ${boardVO.view_count}
             </span>
             <span class="plot"><b>│</b></span>
                <span>${boardVO.register_date}</span>
            </div>
    
        <div>${boardVO.content}</div>
        </div>
        <div style="margin-top : 20px">
           
            <c:if test="${member!=null}">
	            <c:if test="${member.userid == boardVO.userid}">
		            <button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>
		            <button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>
	            </c:if>
            </c:if>
            <button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
        </div>
        
        <div>
        	
        </div>
    </div>
    
</body>
</html>