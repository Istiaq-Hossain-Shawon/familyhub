<!-- GLOBAL HEADER -->
<!-- GLOBAL HEADER -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- COURSE COVER IMAGE -->


<!-- MAIN CONTENT OF THE PAGE -->
<div class="container">

	<div class="col col-lg-12 col-md-12 col-sm-12 col-12">
	
		<div class="ui-block-title">
			<h3 class="title">পরিবার পরিচিতি কার্ড</h3>
		</div>

		<div class="ui-block">

			<!-- News Feed Form  -->

			<div class="news-feed-form" style="padding: 10px;">
				<div id="home-1" aria-expanded="true">
					<form:form action="${pageContext.request.contextPath }/familyInfo/update"
							modelAttribute="familyInfo" enctype="multipart/form-data">
							<form:input path="familyId" value="${familyInfo.familyId}" hidden="hidden" />
					<div class="form-group row mb-10">
						<label for="inputEmail3" class="col-sm-2 col-form-label">কার্ড	নং</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputcardNo" value="${familyInfo.cardNo}"
								name="cardNo" placeholder="কার্ড নং">
						</div>
					</div>
					<div class="form-group row mb-10">
						<label for="area" class="col-sm-2 col-form-label">অঞ্চল			</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="area" name="area" value="${familyInfo.area}"
								placeholder="অঞ্চল">
						</div>

						<label for="ward" class="col-sm-2 col-form-label">ওয়ার্ড
						</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="ward" name="ward" value="${familyInfo.ward}"
								placeholder="ওয়ার্ড">
						</div>
						<label for="thana" class="col-sm-2 col-form-label">থানা

						</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="c" name="thana" value="${familyInfo.thana}"
								placeholder="থানা">
						</div>
					</div>
					<div class="form-group row mb-10">
						<label for="name" class="col-sm-2 col-form-label">নাম
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" value="${familyInfo.name}"
								name="name" placeholder="নাম">
						</div>
					</div>

					<div class="form-group row mb-10">
						<label for="spouseName" class="col-sm-2 col-form-label">স্বামী/স্ত্রী
							নাম </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="spouseName" value="${familyInfo.spouseName}"
								name="spouseName" placeholder="স্বামী/স্ত্রী নাম">
						</div>
					</div>

					<div class="form-group row mb-10">
						<label for="profession" class="col-sm-2 col-form-label">পেশা
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="profession" value="${familyInfo.profession}"
								name="profession" placeholder="পেশা">
						</div>
					</div>

					<div class="form-group row mb-10">
						<label for="mobileNo" class="col-sm-2 col-form-label">মোবাইল
							নাম্বার </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mobileNo" value="${familyInfo.mobileNo}"
								name="mobileNo" placeholder="মোবাইল নাম্বার">
						</div>
					</div>

					<div class="form-group row mb-10">
						<label for="nationalId" class="col-sm-2 col-form-label">জাতীয়
							পরিচয় পত্র </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="nationalId" value="${familyInfo.nationalId}"
								name="nationalId" placeholder="জাতীয় পরিচয় পত্র">
						</div>
					</div>
				
					
					

							<div class="post-block-photo js-zoom-gallery">

								<c:if test="${not empty familyInfo.familyImage}">
									<div class="form-group col-md-4">
										<table class="table">
											<tr>
												<th>Images</th>
												
											</tr>
											<c:forEach items="${familyInfo.familyImage}" var="image">

												<tr>
													<th>
														<a href="${pageContext.request.contextPath }/img/${image.imagePath}"	class="col col-12-width">
															<img 		src="${pageContext.request.contextPath }/img/${image.imagePath}" alt="photo">
														</a>
													</th>
													
												</tr>
											</c:forEach>

										</table>
									</div>
								</c:if>
							</div>

					
					</form:form>
				</div>

			</div>

			<!-- ... end News Feed Form  -->
		</div>
	
	
	
	</div>


</div>


<!-- GLOBAL FOOTER -->
<jsp:include page="/WEB-INF/views/common/footer.jsp" />




