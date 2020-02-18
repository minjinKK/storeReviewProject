<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<jsp:include page="css.jsp"></jsp:include>
<link rel="stylesheet" href="./Resouces/css/styleSignUp.css">
<title>회원가입</title>
</head>
<body>
	<input type="hidden" name="signUpResult" id="res" value="${signUpResult}"/>
  	<div class="page-alerts" id="alert-form" style="display:none">
	    <div class="alert alert-danger page-alert" id="alert-4" style="margin:0">
	         <strong>회원가입 실패!</strong> 이미 등록된 아이디 입니다.
	   </div>
	</div>
	<div class="wrapper fadeInDown col-md-12 py-1">
	  <div id="formContent">
	    <!-- Tabs Titles -->
	
	    <!-- Icon -->
	    <div class="fadeIn first">
	      <div style='margin-top:1.5em'><img src="https://www.b-cube.in/wp-content/uploads/2014/05/aditya-300x177.jpg" id="icon" alt="User Icon" />
	      </div>
	      <div style='margin:0.5em'><h1 style="margin:2px">식당 순위(가제)</h1></div>
	    </div>
	
	    <!-- Login Form -->
	    <form action="signUpOK.do">
	      <input type="text" id="login" class="fadeIn first" name="memberid" placeholder="id를 입력해주세요">
	      <input type="password" id="password" class="fadeIn second" name="memberpw" placeholder="비밀번호를 입력해주세요">
	      <input type="text" id="email" class="fadeIn third" name="memberemail" placeholder="이메일를 입력해주세요">
	      <input type="submit" class="fadeIn fourth" value="Log In">
	    </form>
	
	    <!-- Remind Passowrd -->
	    <div id="formFooter">
	      <a class="underlineHover" href="#">Go to the Site</a>
	    </div>
	  </div>
	</div>
	<jsp:include page="javaScript.jsp"></jsp:include>
  	<script type="text/javascript">
 	$( document ).ready(function() {
 		var value = $("#res").val();
 		if(value == null) $("#alert-form").hide();
 		else if(value == "fail") $("#alert-form").show();
	});
	</script>
</body>
</html>