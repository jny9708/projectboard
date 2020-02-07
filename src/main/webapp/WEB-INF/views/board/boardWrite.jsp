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

<title>게시글 작성</title>
</head>
<style>
    body{
        background-color: white;
    }
    .l-container{
        height: auto;
    align-items: flex-start;
    
    }
    h2{
        margin: 60px 0px 60px 0px;
        text-align: center;
    }
    .l-container form{
    width:60%;
    height: auto;
    }
</style>
<script type="text/javascript">

var modify = '${modify}';

$(function(){
	if(modify=='true'){
		$("#formId").attr('action', '<c:url value="/board/modify"/>');
		$('input[name=title]').val('${boardVO.title}');
		$("textarea[name=content]").text('${boardVO.content}');
		$('input[name=member_id]').val('${boardVO.id}');
		$('input[name=member_id]').attr('name','id')	
		$('.btn-block').html('게시글 수정');
	}
});

function submitcheck() {
	var title = $('input[name=title]').val();
	var content = $('textarea[name=content]').val();
	if(title == ''||content ==''){
		alert('제목 혹은 내용을 채워주세요.');
		return false;
	}else{
		return true;
	}
}

</script>
<body>
	<h2>게시글 작성</h2>
    <div class="l-container">
    
        <form id="formId" action="<c:url value="/board/add"/>" method="POST" onsubmit="return submitcheck()">   
        <table class="table table-bordered">
            <tbody>
            <input type="hidden" name="member_id" value="${member.id}"/>
            <tr>
                <th scope="row">제목</th>
                <td>
                        <input name="title" class="form-control" type="text"> 
                </td>
            </tr>
            <tr>

                <th scope="row">내용</th>
                <td>
                    <textarea name="content" class="form-control" rows="6"></textarea>    
                </td>
            </tr>
        </tbody> 
        </table>
        <button type="submit" class="btn btn-primary btn-block" >게시글 등록</button>
      </form>
    </div>
</body>
</html>