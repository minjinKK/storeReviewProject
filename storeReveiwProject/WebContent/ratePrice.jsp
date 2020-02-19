<%@page import="project.com.model.PlaceVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import ="project.com.model.ScoreVO" %>
<%
    ArrayList<ScoreVO> slist = (ArrayList<ScoreVO>) request.getAttribute("list");
	ArrayList<PlaceVO> plist = (ArrayList<PlaceVO>) request.getAttribute("placeList");
	String session_id = (String)session.getAttribute("memberid");
%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<title>IDTasty Road</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<jsp:include page="css.jsp"></jsp:include>
</head>
<body>
<h6 style="text-align: right"><%=session_id %>님 환영합니다.</h6>
	<div id="colorlib-page">
		<div id="colorlib-main">
			<section class="ftco-section ftco-no-pt ftco-no-pb">
				<div class="container">
					<div class="row d-flex">
						<div class="col-xl-12 py-5 px-md-5">
							<div class="row pt-md-4">
								<div class="col-md-12 py-5">
									<a href="rateTotal.do"><h2 style="text-align: center">IDTasty Road</h2></a>
								</div>
								<div class="col-md-12 py-3">
									<form action="searchAll.do" class="search-form">
										<div class="form-group">
											<span class="icon icon-search"></span> <input type="text" name="searchWord"
												class="form-control"
												placeholder="Type a keyword and hit enter">
										</div>
									</form>
								</div>
								
								<div class="col-md-12 py-5">
									<nav>
										<div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
											<a class="nav-item nav-link" id="nav-home-tab"
												 href="rateTotal.do" role="tab"
												aria-controls="nav-home" aria-selected="false">총점</a> <a
												class="nav-item nav-link" id="nav-profile-tab"
												href="rateTaste.do" role="tab"
												aria-controls="nav-profile" aria-selected="false">맛</a>
											<a class="nav-item nav-link  active" id="nav-about-price"
												href="ratePrice.do" role="tab"
												aria-controls="nav-about" aria-selected="true">가성비</a>
											<a class="nav-item nav-link" id="nav-contact-tab"
												 href="rateDistance.do" role="tab"
												aria-controls="nav-contact" aria-selected="false">거리</a>
											<a class="nav-item nav-link" id="nav-about-tab"
												 href="rateCircul.do" role="tab"
												aria-controls="nav-about" aria-selected="false">회전율</a>
										</div>
								</div>
								<div class="col-md-12  py-1">
								<nav class="navbar navbar-expand-lg navbar-left">
									<div class="collapse navbar-collapse" id="navbarNavDropdown">
										<ul class="navbar-nav">
											<li class="nav-item dropdown"><a class="nav-link" href="#"
												id="navbarDropdownMenuLink" data-toggle="dropdown"
												aria-haspopup="true" aria-expanded="false"> 카테고리 <span
													class="icon-arrow-down"></span>
											</a>
												<div class="dropdown-menu"
													aria-labelledby="navbarDropdownMenuLink">
													<a class="dropdown-item" value="전체">전체</a> 
													<a class="dropdown-item" value="한식">한식</a> 
													<a class="dropdown-item" value="양식">양식</a> 
													<a class="dropdown-item" value="중식">중식</a>
													<a class="dropdown-item" value="인도식">인도식</a>
													<a class="dropdown-item" value="태국식">태국식</a>
													<a class="dropdown-item" value="카페">카페</a>
												</div>
											</li>
										</ul>
									</div>
								</nav>
							</div>
							<!--  비동기 리스트 -->
							<div class="col-md-12" id="rate-wrap">
							</div>
							<!--  비동기 리스트  end-->
								
							</div>
							<!-- END-->
							<!--  
							<div class="row">
								<div class="col">
									<div class="block-27">
										<ul>
											<li><a href="#">&lt;</a></li>
											<li class="active"><span>1</span></li>
											<li><a href="#">2</a></li>
											<li><a href="#">3</a></li>
											<li><a href="#">4</a></li>
											<li><a href="#">5</a></li>
											<li><a href="#">&gt;</a></li>
										</ul>
									</div>
								</div>
							</div>
							-->
						</div>

					</div>
					<!-- END COL -->
				</div>
		</div>
		</section>
	</div>
	<!-- END COLORLIB-MAIN -->
	</div>
	<!-- END COLORLIB-PAGE -->
	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>
	<jsp:include page="javaScript.jsp"></jsp:include>
	<script>
	$(document).ready(function() {
		var category = '';
		loadRate(category);
		$('.dropdown-item').on('click', function() {
		    // 버튼에 선택된 항목 텍스트 넣기 
		    //$('#mystatus').text($(this).text());
		    // 선택된 항목 값(value) 얻기
		    //alert($(this).attr('value'));
		    //$("#rate-wrap").load(window.location.href + "#rate-wrap");
		    category = ($(this).attr('value')=='전체') ? "": $(this).attr('value');
			loadRate(category);
		});
		
		function loadRate(category) {
			console.log("category....."+category);
			$.get("json_ratePrice.do", function(data, status) {
				console.log(data);
				/* let str = "";
				for ( var i in data[0]) {
					str += data[0][i].pname + "," + data[0][i].total + " ";
				}
				for ( var i in data[1]) {
					str += data[1][i].p_name + "," + data[1][i].p_address + " ";
				}
				$("#rate-wrap").html(str); */
				/////////////////////////////////////////////////////////////////////
				let str = "";
				let rank = 1;
				for(var i in data[0]){
					if( category != '' && data[1][i].p_country != category) {
						continue;
					}
					str += "<div class='col-md-12'>";
					str += "<div class='blog-entry ftco-animate  d-md-flex'>";
					str += "<a href='review.do?p_name="+data[0][i].pname+"'";
					str += "class='img img-2' style='background-image: url(./Resouces/images/"+data[1][i].p_img_name+");'>"+rank+"</a>";
					str +="<div class='text text-2 pl-md-4'><h3 class='mb-2'><a href='review.do?p_name="+data[0][i].pname+"'>"+data[0][i].pname+"</a>";
					str +="</h3><div class='meta-wrap'><p class='meta'><div id='meta-detail'><span style='margin-right: 10px'>총점<i class='icon-star mr-2'></i>"+data[0][i].total+"</span>"; 
					str += "<span style='margin-right: 10px'><i class='icon-folder-o mr-2'></i>"+data[1][i].p_country+"</span><span style='margin-right: 10px'>";
					str += "<i class='icon-comment2 mr-2'></i>"+data[0][i].count+" Comment</span></div></p></div>";
					str += "<p class='mb-4'>정말 맛있는 "+data[1][i].p_country+" 집"+ data[0][i].pname+"의 주소는 ?    ["+data[1][i].p_address+"]</p></div>";
					str += "</div>";
					str += "</div>";
					rank++;
				}
				$("#rate-wrap").html(str);
				contentWayPoint();//main.js에있는 전역함수!
			}); //endget
		}
	}); // end ready()
	</script>
</body>
</html>