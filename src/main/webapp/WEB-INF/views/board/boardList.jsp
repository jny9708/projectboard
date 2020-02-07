<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
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
    	margin-bottom:20px;
    	float:right;
        width: 15%;
    }
    nav {
    	margin:25px 0px;
    	display:flex;
    	justify-content: center;
    }
    
</style>

<script type="text/javascript">
	var msgs = '${msgs}';
	$(function(){
		if(msgs!=''){
			alert(msgs);
		}	
	});
	

	function pagination(page, rangeSize){
		var url = '<c:url value="/"/>';
		url = url + "?page=" + page;
		location.href = url;
	}
	
	function fn_next(){
		var page = ${pagination.endPage} + 1;
		var url = '<c:url value="/"/>';
		url = url + "?page=" + page;
		location.href = url;
	}

	function fn_prev(){
		var page = ${pagination.startPage} - 1; //그 전 블럭의 첫페이지를 계산한다.
		var url = '<c:url value="/"/>';
		url = url + "?page=" + page;
		console.log(url);
		location.href = url;
	}
	
	 $(function(){
		$('#btnWrite').click(function(){
			 var url = '<c:url value="/board/write"/>';
			 location.href = url;
			
		});
	 });
</script>    
<body>  
	<h2>게시글 목록</h2>
    <div class="l-container">
        
        <div class="t-container table-responsive">
        <c:choose>
	        <c:when test="${member == null}">
	        	<a href="<c:url value="/login"/>">로그인</a>
	        </c:when>
	        <c:otherwise>
	        	<b>${member.userid}님 안녕하세요.</b> 
	        	<a href="<c:url value="/logout"/>">로그아웃</a>
	        </c:otherwise>
        </c:choose>
        <button type="button" id="btnWrite" class="btn btn-primary btn-block" >게시글 등록</button>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>NO</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>등록일</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="board" items="${boardList}">
            <tr>
                <td>${board.id}</td>
                <td><a href="<c:url value="/${board.id}"/>">${board.title}</a></td>
                <td>${board.userid}</td>
                <td>${board.view_count}</td>
                <td>${board.register_date}</td>
            </tr>
            </c:forEach>
        </tbody> 
        </table>
        
        <nav>
		  <ul class="pagination">
		  <c:if test="${pagination.prev}">
		   <li class="page-item">
		   		<a class="page-link" href="#" onclick="fn_prev()">
		   		&lt;
		   		</a>
		   </li>
		    </c:if>
		    <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
		    	<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/>"><a href="#" onclick="pagination('${idx}', '${pagination.rangeSize}')" class="page-link">${idx}</a></li>
		    </c:forEach>
		    
		    <c:if test="${pagination.next}">
			    <li class="page-item">
			      <a  class="page-link"  href="#" onclick="fn_next()">
			        <span aria-hidden="true">&gt;</span>
			      </a>
			    </li>
		    </c:if>
		  </ul>
		</nav>

        </div>
        
    </div>
</body>
</html>
