<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/Bootstrap/dist/css/bootstrap-reboot.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/Bootstrap/dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/Bootstrap/dist/css/bootstrap-grid.css">


<!-- Main Styles CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/main.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/fonts.min.css">

</head>

<body class="landing-page">







	<!-- ... end Header Standard Landing  -->
	<div class="header-spacer--standard"></div>

	<div class="container">
		<div class="registration-login-form">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li class="nav-item"><a class="nav-link active"
					data-toggle="tab" href="" role="tab"> </a></li>

			</ul>

			<!-- Tab panes -->
			<div class="tab-content">


				<div class="tab-pane active" id="profile" role="tabpanel"
					data-mh="log-tab">
					<div class="title h6">আপনার অ্যাকাউন্ট এ লগ ইন করুন</div>
					<form class="content"
						action="${pageContext.request.contextPath }/login-processing"
						method="POST">
						<div class="row">
							<div class="col col-12 col-xl-12 col-lg-12 col-md-12 col-sm-12">

								<div class="row">
									<div class="col-xl-1">
										<label class="control-label"> ইমেইল  </label>
									</div>
									<div class="col-xl-8">
										<input class="form-control" placeholder="" type="email"
											name="username">
									</div>

								</div>



								<div class="row">
									<div class="col-xl-1">
										<label class="control-label"> পাসওয়ার্ড</label>
									</div>
									<div class="col-xl-8">

										<input class="form-control" placeholder="" type="password"
											name="password">

									</div>

								</div>


								<c:if test="${error == 'true'}">
									<div class="alert alert-danger" role="alert">ভুল ইমেইল
										অথবা পাসওয়ার্ড</div>
								</c:if>
								<button type="submit" class="btn btn-lg btn-primary full-width">লগ ইন</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>



	</div>


	<!-- JS Scripts -->

	<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery.appear.js"></script>
	<script
		src="${pageContext.request.contextPath }/js/jquery.mousewheel.js"></script>
	<script
		src="${pageContext.request.contextPath }/js/perfect-scrollbar.js"></script>
	<script src="${pageContext.request.contextPath }/js/Headroom.js"></script>

	<script src="${pageContext.request.contextPath }/js/material.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/js/bootstrap-select.js"></script>
	<script src="${pageContext.request.contextPath }/js/smooth-scroll.js"></script>

	<script src="${pageContext.request.contextPath }/js/jquery-ui.js"></script>
	<script src="${pageContext.request.contextPath }/js/base-init.js"></script>
	<script defer
		src="${pageContext.request.contextPath }/fonts/fontawesome-all.js"></script>
	<script src="${pageContext.request.contextPath }/js/selectize.js"></script>
	<script
		src="${pageContext.request.contextPath }/css/Bootstrap/dist/js/bootstrap.bundle.js"></script>






</body>
</html>