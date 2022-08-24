<!-- GLOBAL HEADER -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="/WEB-INF/views/common/header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- COURSE COVER IMAGE -->
<style>
.mb-10 {
	margin-bottom: 10px !important;
}
</style>

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
					<div class="form-group row mb-10">
						<label for="inputEmail3" class="col-sm-2 col-form-label">কার্ড
							নং</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputcardNo"
								name="cardNo" placeholder="কার্ড নং">
						</div>
					</div>
					<div class="form-group row mb-10">
						<label for="inputEmail3" class="col-sm-2 col-form-label">অঞ্চল
						</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="inputcardNo" name=""
								placeholder="অঞ্চল">
						</div>

						<label for="inputEmail3" class="col-sm-2 col-form-label">ওয়ার্ড
						</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="inputcardNo" name=""
								placeholder="ওয়ার্ড">
						</div>
						<label for="inputEmail3" class="col-sm-2 col-form-label">থানা

						</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="inputcardNo" name=""
								placeholder="থানা">
						</div>
					</div>
					<div class="form-group row mb-10">
						<label for="inputEmail3" class="col-sm-2 col-form-label">নাম
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputcardNo"
								name="cardNo" placeholder="নাম">
						</div>
					</div>

					<div class="form-group row mb-10">
						<label for="inputEmail3" class="col-sm-2 col-form-label">স্বামী/স্ত্রী
							নাম </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputcardNo"
								name="cardNo" placeholder="স্বামী/স্ত্রী নাম">
						</div>
					</div>

					<div class="form-group row mb-10">
						<label for="inputEmail3" class="col-sm-2 col-form-label">পেশা
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputcardNo"
								name="cardNo" placeholder="পেশা">
						</div>
					</div>

					<div class="form-group row mb-10">
						<label for="inputEmail3" class="col-sm-2 col-form-label">মোবাইল
							নাম্বার </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputcardNo"
								name="cardNo" placeholder="মোবাইল নাম্বার">
						</div>
					</div>

					<div class="form-group row mb-10">
						<label for="inputEmail3" class="col-sm-2 col-form-label">জাতীয়
							পরিচয় পত্র </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputcardNo"
								name="cardNo" placeholder="জাতীয় পরিচয় পত্র">
						</div>
					</div>
					<div class="form-group row mb-10">


						<label for="image" class="col-sm-2 col-form-label">ছবি: </label>
						<div class="col-sm-10">
							<input type="file" name="images" multiple="multiple" />
						</div>


					</div>

					<input type="submit" class="btn btn-primary btn-md-2" value="অ্যাড করুন"
						style="width: 15%; float: right; margin-top: 5px;">

				</div>

			</div>

			<!-- ... end News Feed Form  -->
		</div>
	</div>


</div>


<!-- GLOBAL FOOTER -->
<jsp:include page="/WEB-INF/views/common/footer.jsp" />




