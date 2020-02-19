<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<jsp:include page="css.jsp"></jsp:include>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="./Resouces/css/styleSignUp.css">
<title>회원가입</title>
</head>
<body>
  	<div class="page-alerts" id="alert-form" style="display:none">
  		<input type="hidden" name="signUpResult" id="res" value="${signUpResult}"/>
	    <div class="alert alert-danger page-alert" id="alert-4" style="margin:0">
	         <strong>회원가입 실패!</strong> 이미 등록된 아이디 입니다.
	   </div>
	</div>
	<div class="wrapper fadeInDown col-md-12 py-1">
	  <div id="formContent">
	    <!-- Tabs Titles -->
	
	    <!-- Icon -->
	    <div class="fadeIn first">
	      <div style='margin-top:1.5em'><img src="./Resouces/images/idt_ci.jpg" id="icon" alt="User Icon" />
	      </div>
	      <div style='margin:0.5em'><h1 style="margin:2px">IDTasty Road</h1></div>
	    </div>
	
	    <!-- Login Form -->
	    <form action="signUpOK.do" id="signUpForm">
	      <input type="text" id="logid" class="fadeIn first" name="memberid" placeholder="id를 입력해주세요">
	      <input type="password" id="password" class="fadeIn second" name="memberpw" placeholder="비밀번호를 입력해주세요">
	      <input type="text" id="email" class="fadeIn third" name="memberemail" placeholder="이메일를 입력해주세요">
	      <input type="submit" class="fadeIn fourth" value="Log In" id="signUpBtn">
	    </form>
	
	    <!-- Remind Passowrd -->
	    <div id="formFooter">
	      <a class="underlineHover" href="index.do">Go to the Site</a>
	      <!-- <input type="button" id ="btnTest" value="Test"/> -->
	    </div>
	  </div>
	</div>
	<!-- dialog -->
	 <div id="dialog" title="Alert message" style="display: none">
           <div class="ui-dialog-content ui-widget-content">
               <p>
                   <span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0"></span>
                   <label id="lblMessage">
                   </label>
               </p>
           </div>
     </div>
		
	<jsp:include page="javaScript.jsp"></jsp:include>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  	<script type="text/javascript">
 	$( document ).ready(function() {
 		var value = $("#res").val();
 		if(value == null) $("#alert-form").hide();
 		else if(value == "idCheck") $("#alert-form").show();
 		$('#signUpForm').submit(function(){
 			if(isEmpty($('#logid').val())){
 			ShowCustomDialog('ID를'); 
 			return false;
 			}
 		else if(isEmpty($('#password').val())){
 			ShowCustomDialog('PW를');
 			return false;
 			}
 		else if(isEmpty($('#email').val())){
 			ShowCustomDialog('E-MAIL을');
 			return false;
 			}
		});
 		/* 
 		$('#btnTest').click(function(){
 			if(isEmpty($('#logid').val())){
 				ShowCustomDialog('ID');
 			}
 		});
 		*/
});
 	function isEmpty(str){
 		if(typeof str == "undefined" || str == null || str == "")
 			return true;
 		else
 			return false ;
 	}
 	function ShowCustomDialog(emptyVal){
 		ShowDialogBox('Warning',emptyVal+' 입력해주세요','Ok','', 'GoToAssetList',null);
 	}
 	function ShowDialogBox(title, content, btn1text, btn2text, functionText, parameterList) {
 		var btn1css;
 		var btn2css;
 		if (btn1text == '') {
 			btn1css = "hidecss";
 			}
 		else {
 				btn1css = "showcss";
 				}
 		if (btn2text == '') {
 			btn2css = "hidecss";
 			} 
 		else {
 			btn2css = "showcss";
 			}
 		$("#lblMessage").html(content);
 		$("#dialog").dialog({
 			 resizable: false,
 			 title: title,
 			 modal: true,
 			 width: '400px',
 			 height: 'auto',
 			 bgiframe: false,
 			 hide: { effect: 'scale', duration: 400 },
 			 buttons: [
 				 {
 					 text: btn1text,
 					 "class": btn1css,
 					 click: function () {
 						 $("#dialog").dialog('close');
 						}
 				 }]
 		});
 	}
	</script>
</body>
</html>