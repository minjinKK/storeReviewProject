<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%


	String session_id = (String) session.getAttribute("memberid");
	String p_name = (String) request.getAttribute("p_name");
%>
<html lang="en">
<head>
<title>리뷰작성<%=session_id %></title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<jsp:include page="css.jsp"></jsp:include>
</head>
<body>
	<div id="colorlib-page">
		<div id="colorlib-main">
			<section class="ftco-section ftco-no-pt ftco-no-pb">
				<div class="container">
					<div class="row d-flex">
						<div class="col-lg-12 px-md-5 py-5">
							<div class="col-md-12 py-5">
								<a href="rateTotal.do"><h2 style="text-align: center">IDTasty Road</h2></a>
							</div>

							<!--
								<div class="about-author bg-light col-xs-12">
									<div class="desc">
										<div class="well well-sm">
								            <div class="row" id="post-review-box">
								                <div class="col-md-12">
								                    <form accept-charset="UTF-8" action="" method="post">
								                        <input id="ratings-hidden" name="rating" type="hidden"> 
								                        <textarea class="form-control animated" cols="50" id="new-review" name="comment" placeholder="Enter your review here..." rows="5"></textarea>
								   						
								                        <div class="text-right">
								                            <div class="stars starrr" data-rating="0"></div>
								                            <a class="btn btn-danger btn-sm" href="#" id="close-review-box" margin-right: 10px;">
								                            <span class="glyphicon glyphicon-remove"></span>Cancel</a>
								                            <button class="btn btn-success btn-lg" type="submit">Save</button>
								                        </div>
								                    </form>
								                </div>
								            </div>
								        </div> 
									</div>
								</div>
								-->
							<div class="col-md-12 py-1">
								<div class="comment-form-wrap pt-5">
									<div class="tag-widget post-tag-container col-xs-12">
										<h2 class="mb-5"><%=p_name%></h2>
									</div>
									<div class="col-xs-12 review_box">
										<p class="review__text">맛</p>
										<div class="stars starrr" data-rating="0" id="star_taste"></div>
										<!-- <div class="review__titl">You gave a rating of <span id="count">0</span> star(s)</div>-->
									</div>
									<div class="col-xs-12 review_box">
										<p class="review__text">가성비</p>
										<div class="stars starrr" data-rating="0" id="star_price"></div>
									</div>
									<div class="col-xs-12 review_box">
										<p class="review__text">회전율</p>
										<div class="stars starrr" data-rating="0" id="star_circul"></div>
									</div>
									<div class="col-xs-12 review_box">
										<p class="review__text">거리</p>
										<div class="stars starrr" data-rating="0" id="star_distance"></div>
									</div>
									<div class="col-xs-12 review_box">
										<p class="review__text">총점</p>
										<div class="stars starrr" data-rating="0" id="star_total"></div>
									</div>
								</div>
								<div class="col-md-12 py-1">
									<div class="comment-form-wrap pt-5">
										<h3 class="mb-5">평가 쓰기</h3>
										<form action="insertReview.do" class="p-3 p-md-5 bg-light" id="rates">
											<input name = "p_name" type="hidden" value="<%=p_name %>" >
											<input name="memberid" type="text" value="<%=session_id%>"readonly> 
											<input id="r_taste" name="rating_taste"type="hidden" > 
											<input id="r_price"name="rating_price" type="hidden"> 
											<input id="r_circul" name="rating_circul" type="hidden"> 
											<input id="r_distance" name="rating_distance" type="hidden">
											<input id="r_total" name="rating_total" type="hidden">
											<div class="form-group">
												<textarea name="r_text" id="message" cols="30" rows="10"
													class="form-control">너무 맛있는 우리회사 맛집!</textarea>
											</div>
											<div class="form-group">
												<input type="submit" value="리뷰 남기기!"
													class="btn py-3 px-4 btn-primary">
											</div>
										</form>
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
							</div>
							<!-- END-->
						</div>
						<div class="col-lg-4 sidebar ftco-animate bg-light pt-5"></div>
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
	<script src="./Resouces/js/progressbar.js"></script>
	<script src="./Resouces/js/reviewstar3.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script>
	$(document).ready(function() {
		var value = $("#res").val();
 		if(value == null) $("#alert-form").hide();
 		else if(value == "idCheck") $("#alert-form").show();
 		$('#rates').submit(function() {
	        if ($('#r_taste').val() == 0) {
	            alert('맛의 점수를 매겨주세요!');
	            return false;
	        }
	        else if ($('#r_price').val() == 0) {
	            alert('가성비의 점수를 매겨주세요!');
	            return false;
	        }
	        else if ($('#r_circul').val() == 0) {
	            alert('회전율의 점수를 매겨주세요!');
	            return false;
	        }
	        else  if ($('#r_distance').val() == 0) {
	            alert('거리의 점수를 매겨주세요!');
	            return false;
	        }
	        else  if ($('#r_total').val() == 0) {
	            alert('총 점수를 매겨주세요!');
	            return false;
	        }
	        else  if ($('#message').val() == '') {
	            alert('코멘트를 남겨주세요!');
	            return false;
	        }
	    }); // end submit()
	}); // end ready()
	</script>
</body>
</html>