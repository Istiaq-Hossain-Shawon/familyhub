<%@ page language="java" contentType="text/html;  charset=UTF-8"
         pageEncoding="UTF-8" %>
         
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<style>

.header .page-title>* {
    color: #888da8 !important;
    margin: 0;
}
</style>
<head>
    <meta charset="ISO-8859-1">
    <title>Family Hub</title>


</head>
<body>

<header class="header" id="site-header">
	<div class="page-title">
		<a   class="author-name fn" href="${pageContext.request.contextPath}/">
		<span class="author-title">হোম</span>					
				</a>
		
	</div>
	
	<div class="header-content-wrapper">		
		

		<div class="control-block">
			<div class="author-page author vcard inline-items more">
				<div class="author-thumb">
					
					<div class="more-dropdown more-with-triangle">
						<div class="mCustomScrollbar" data-mcs-theme="dark">
							<div class="ui-block-title ui-block-title-small">
								<h6 c	lass="title">আপনার অ্যাকাউন্ট</h6>
							</div>
							<ul class="account-settings">								
								<li>
									<a href="${pageContext.request.contextPath}/account/index">
										<svg class="olymp-star-icon left-menu-icon"  data-toggle="tooltip" data-placement="right"   data-original-title="FAV PAGE"><use xlink:href="svg-icons/sprites/icons.svg#olymp-star-icon"></use></svg>

										<span>অ্যাকাউন্ট</span>
									</a>
								</li>
								<li>								 
									<a href="${pageContext.request.contextPath}/logout">
										<svg class="olymp-logout-icon"><use xlink:href="svg-icons/sprites/icons.svg#olymp-logout-icon"></use></svg>

										<span>লগ আউট </span>
									</a>
								</li>
							</ul>
						</div>

					</div>
				</div>
				<a  class="author-name fn">
					<div class="author-title">
					<sec:authentication var="principal" property="principal" />
					${principal.username}
						<svg class="olymp-dropdown-arrow-icon">
						<use xlink:href="svg-icons/sprites/icons.svg#olymp-dropdown-arrow-icon"></use></svg>
					</div>
					<span class="author-subtitle"></span>
				</a>
			</div>

		</div>
	</div>

</header>

<!-- ... end Header-BP -->




<!-- ... end Responsive Header-BP -->
<div class="header-spacer"></div>





<!-- Header-BP -->

</body>
