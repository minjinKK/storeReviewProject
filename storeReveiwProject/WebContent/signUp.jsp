<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<jsp:include page="css.jsp"></jsp:include>

<title>회원가입</title>
</head>
<body>
<div class="col-md-12 py-1">
	<div class="comment-form-wrap pt-5">
		<h3 class="mb-5">회원가입</h3>
		<form action="signUpOK.do" class="p-3 p-md-5 bg-light">
			
			아이디: <input name="memberid" type="text" > 
			비밀번호: <input name="memberpw" type="password" > 
			이메일: <input name="memberemail" type="text" > 
			
			<div class="form-group">
				<input type="submit" value="회원가입" class="btn py-3 px-4 btn-primary">
			</div>
		</form>
	</div>
</div>
</body>
</html>