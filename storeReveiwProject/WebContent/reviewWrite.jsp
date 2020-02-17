<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String session_id = (String) session.getAttribute("memberid");
	String p_name = (String) request.getAttribute("p_name");
%>
<html lang="en">
<head>
<title>리뷰작성</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
								<h2 style="text-align: center">식당 순위(가제)</h2>
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
										<form action="insertReview.do" class="p-3 p-md-5 bg-light">
											<input name = "p_name" type="hidden" value="<%=p_name %>" >
											<input name="memberid" type="text" value="<%=session_id%>"readonly> 
											<input id="r_taste" name="rating_taste"type="hidden" > 
											<input id="r_price"name="rating_price" type="hidden"> 
											<input id="r_circul" name="rating_circul" type="hidden"> 
											<input id="r_distance" name="rating_distance" type="hidden">
											<input id="r_total" name="rating_total" type="hidden">
											<div class="form-group">
												<textarea name="r_text" id="message" cols="30" rows="10"
													class="form-control"></textarea>
											</div>


											<div class="form-group">
												<input type="submit" value="리뷰 남기기!"
													class="btn py-3 px-4 btn-primary">
											</div>
										</form>
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
	<script src="./Resouces/js/reviewstar2.js"></script>
	<script type="text/javascript">
		$('#star_taste').on('starrr:change', function(e, value) {
			// alert(value);
			$('#r_taste').val(value);
			console.log(value);
		});
		$('#star_price').on('starrr:change', function(e, value) {
			$('#r_price').val(value);
// 			alert(value);
		});
		$('#star_circul').on('starrr:change', function(e, value) {
			$('#r_circul').val(value);
// 			alert(value);
		});
		$('#star_distance').on('starrr:change', function(e, value) {
			$('#r_distance').val(value);
// 			alert(value);
		});
		$('#star_total').on('starrr:change', function(e, value) {
			$('#r_total').val(value);
// 			alert(value);
		});
	</script>
</body>
</html>