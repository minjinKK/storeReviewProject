<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>로그인페이지</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <jsp:include page="css.jsp"></jsp:include>
  </head>
  <body>
  	<input type="hidden" name="loginResult" id="res" value="${loginResult}"/>
  	<div class="page-alerts" id="alert-form" style="display:none">
	    <div class="alert alert-danger page-alert" id="alert-4" style="margin:0">
	         <strong>로그인 실패!</strong> 아이디와 비밀번호를 다시 확인해주세요.
	   </div>
	</div>
    <!-- SLIDER -->
    <section class="slider d-flex align-items-center">
        <!-- <img src="./Resouces/images/slider.jpg" class="img-fluid" alt="#"> -->
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-md-12">
                    <div class="slider-title_box">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="slider-content_wrap">
                                    <h1>IDT 주변의 가장 맛있는 한식집은?</h1>
                                    <p style="font-size:20px">지금 바로 IDTasty Road를 통해 확인해보세요!</p>
                                </div>
                            </div>
                        </div>
                        <div class="row d-flex justify-content-center" >
                            <div class="col-md-10">
                                <form class="form-wrap mt-4" action = "login.do" method="post">
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <input type="text" name = "memberid" placeholder="ID" class="btn-group1">
                                        <input type="text" name = "memberpw" placeholder="PASSWORD" class="btn-group2">
                                        <button type="submit" class="btn-form"><span class="icon-magnifier search-icon"></span>로그인<i class="pe-7s-angle-right"></i></button>
                                    </div>
                                </form>
                                <div class="slider-link">
                                    <a href="signUp.do">회원가입</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--// SLIDER -->
    <!--//END HEADER -->
  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>
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