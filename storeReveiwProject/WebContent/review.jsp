<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
<title>상세리뷰보기</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">-->
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
							<div class="row pt-md-4">

								<div class="col-md-6 col-lg-5 " id="review_main_img">
									<img src="./Resouces/images/image_1.jpg"
										alt="Image placeholder" class="img-fluid mb-4">
								</div>
								<div
									class="col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-0 col-lg-offset-1 ">

									<!--  -->
									<div class="mt-30">
										<h2 class="about__title">${placeVO.p_name}</h2>
										<p class="about__subtitle">${placeVO.p_address}</p>
										<p class="about__subtitle">${placeVO.p_tel}</p>
										<p class="about__text">${placeVO.p_description}</p>
										<p class="about__text">${scoreVO.taste}</p>
										<!-- progress -->
										<div class="progress2">
											<h5 class="progress2__title">맛</h5>
											<div class="progress2__wrap">
												<div class="progress2__bar" data-progress-percent="${scoreVO.taste}"
													data-timing="ease" data-duration="1000" data-delay="100"></div>
												<span class="progress2__number">${scoreVO.taste}</span>
											</div>
										</div>
										<!-- End / progress -->


										<!-- progress -->
										<div class="progress2">
											<h5 class="progress2__title">가성비</h5>
											<div class="progress2__wrap">
												<div class="progress2__bar" data-progress-percent="${scoreVO.price}"
													data-timing="ease" data-duration="1000" data-delay="100"></div>
												<span class="progress2__number">${scoreVO.price}</span>
											</div>
										</div>
										<!-- End / progress -->


										<!-- progress -->
										<div class="progress2">
											<h5 class="progress2__title">회전율</h5>
											<div class="progress2__wrap">
												<div class="progress2__bar" data-progress-percent="${scoreVO.circul}"
													data-timing="ease" data-duration="1000" data-delay="100"></div>
												<span class="progress2__number">${scoreVO.circul}</span>
											</div>
										</div>
										<!-- End / progress -->
										
										<!-- progress -->
										<div class="progress2">
											<h5 class="progress2__title">거리</h5>
											<div class="progress2__wrap">
												<div class="progress2__bar" data-progress-percent="${scoreVO.distance}"
													data-timing="ease" data-duration="1000" data-delay="100"></div>
												<span class="progress2__number">${scoreVO.distance}</span>
											</div>
										</div>
										<!-- End / progress -->
										

									</div>
									<!-- End /  -->

								</div>


								<div class="about-author col-xs-12 mt-5">
									<div class="desc">
										<button type="button" class="btn py-3 px-4 btn-primary brn-reveiw-rightnow" onclick="location.href='joinUs.jsp' "><p>지금 리뷰를 남겨주세요!</p></button></h3>
									</div>
								</div>
								<!-- 
								<div class="about-author bg-light col-xs-12">
									<div class="desc">
										<div class="well well-sm">
								            <div class="text-right">
								            	
								                <a class="btn btn-success btn-green" href="#reviews-anchor" id="open-review-box">Leave a Review</a>
								            </div>
								        
								            <div class="row" id="post-review-box" style="display:none;">
								                <div class="col-md-12">
								                    <form accept-charset="UTF-8" action="" method="post">
								                        <input id="ratings-hidden" name="rating" type="hidden"> 
								                        <textarea class="form-control animated" cols="50" id="new-review" name="comment" placeholder="Enter your review here..." rows="5"></textarea>
								        
								                        <div class="text-right">
								                            <div class="stars starrr" data-rating="0"></div>
								                            <a class="btn btn-danger btn-sm" href="#" id="close-review-box" style="display:none; margin-right: 10px;">
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
	
								<div class="pt-5 mt-5">
									<h3 class="mb-5 font-weight-bold">6 Comments</h3>
									<ul class="comment-list">
										<li class="comment">
											<div class="vcard bio">
												<img src="./Resouces/images/person_1.jpg"
													alt="Image placeholder">
											</div>
											<div class="comment-body">
												<h3>John Doe</h3>
												<div class="meta">October 03, 2018 at 2:21pm</div>
												<p>Lorem ipsum dolor sit amet, consectetur adipisicing
													elit. Pariatur quidem laborum necessitatibus, ipsam impedit
													vitae autem, eum officia, fugiat saepe enim sapiente iste
													iure! Quam voluptas earum impedit necessitatibus, nihil?</p>
												<p>
													<a href="#" class="reply">Reply</a>
												</p>
											</div>
										</li>

										<li class="comment">
											<div class="vcard bio">
												<img src="./Resouces/images/person_1.jpg"
													alt="Image placeholder">
											</div>
											<div class="comment-body">
												<h3>John Doe</h3>
												<div class="meta">October 03, 2018 at 2:21pm</div>
												<p>Lorem ipsum dolor sit amet, consectetur adipisicing
													elit. Pariatur quidem laborum necessitatibus, ipsam impedit
													vitae autem, eum officia, fugiat saepe enim sapiente iste
													iure! Quam voluptas earum impedit necessitatibus, nihil?</p>
												<p>
													<a href="#" class="reply">Reply</a>
												</p>
											</div>
										</li>

										<li class="comment">
											<div class="vcard bio">
												<img src="./Resouces/images/person_1.jpg"
													alt="Image placeholder">
											</div>
											<div class="comment-body">
												<h3>John Doe</h3>
												<div class="meta">October 03, 2018 at 2:21pm</div>
												<p>Lorem ipsum dolor sit amet, consectetur adipisicing
													elit. Pariatur quidem laborum necessitatibus, ipsam impedit
													vitae autem, eum officia, fugiat saepe enim sapiente iste
													iure! Quam voluptas earum impedit necessitatibus, nihil?</p>
												<p>
													<a href="#" class="reply">Reply</a>
												</p>
											</div>
										</li>
									</ul>
									<!-- END comment-list -->
									<!-- 
									<div class="comment-form-wrap pt-5">
										<h3 class="mb-5">Leave a comment</h3>
										<form action="#" class="p-3 p-md-5 bg-light">
											<div class="form-group">
												<label for="name">Name *</label> <input type="text"
													class="form-control" id="name">
											</div>
											<div class="form-group">
												<label for="email">Email *</label> <input type="email"
													class="form-control" id="email">
											</div>
											<div class="form-group">
												<label for="website">Website</label> <input type="url"
													class="form-control" id="website">
											</div>

											<div class="form-group">
												<label for="message">Message</label>
												<textarea name="" id="message" cols="30" rows="10"
													class="form-control"></textarea>
											</div>
											<div class="form-group">
												<input type="submit" value="Post Comment"
													class="btn py-3 px-4 btn-primary">
											</div>

										</form>
									</div>
									-->
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
	<script src="./Resouces/js/progressbar2.js"></script>
	<script src="./Resouces/js/reviewstar2.js"></script>

</body>
</html>