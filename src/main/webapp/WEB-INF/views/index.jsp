<!-- GLOBAL HEADER -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="common/header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ta" uri="https://github.com/dernasherbrezon/jtimeago"%>
<!-- COURSE COVER IMAGE -->
<style>
.padding5 {
	padding: 0.5rem !important;
	background-color:white !important;
}
.btn-primary:not(:disabled):not(.disabled).active, .btn-primary:not(:disabled):not(.disabled):active, .show > .btn-primary.dropdown-toggle {
    color: #fff;
    background-color: #38a9ff !important;
    border-color: #38a9ff !important;
}
</style>

<div class="container">
	<div class="row">

		<div
			class="col col-xl-12 order-xl-2 col-lg-12 order-lg-1 col-sm-12 col-12">


			<h3 class="title">পরিবার পরিচিতি কার্ড তথ্য </h3>

<div class="row">
		<div class="col-xl-6">
				<form:form class=""
					action="${pageContext.request.contextPath }/familyInfo/search"
					modelAttribute="familyInfoDto">

<div class="row">

					<div class="col-xl-6">
						<input class="form-control padding5" name="searchContent" 
							placeholder=" সার্চ করার জন্য এই খানে টাইপ করুন" type="text">
					</div>
					<div class="col-xl-6">
						<button type="submit" class="btn btn-primary">সার্চ করুন</button>
					</div>
	
</div>


				</form:form>
			</div>
			<div class="col-xl-6">

				<a class="btn btn-primary" style="float:right"
					href="${pageContext.request.contextPath }/familyInfo/add">নতুন
						অ্যাড করুন</a>
				
			</div>


</div>

	




			<div class="ui-block">



				<table class="table table-sm">
					<tr>
						<th>কার্ড নং</th>
						<th>অঞ্চল</th>
						<th>ওয়ার্ড</th>
						<th>থানা</th>
						<th>নাম</th>
						<th>স্বামী/স্ত্রী নাম</th>
						<th>পেশা</th>
						<th>মোবাইল নাম্বার</th>
						<th>জাতীয় পরিচয় পত্র</th>
						<th>অ্যাকশান</th>
					</tr>
					<c:forEach items="${familyInfos}" var="family">
						<tr>
							<td><c:out value="${family.cardNo}" /></td>
							<td><c:out value="${family.area}" /></td>
							<td><c:out value="${family.ward}" /></td>
							<td><c:out value="${family.thana}" /></td>
							<td><c:out value="${family.name}" /></td>
							<td><c:out value="${family.spouseName}" /></td>
							<td><c:out value="${family.profession}" /></td>
							<td><c:out value="${family.mobileNo}" /></td>
							<td><c:out value="${family.nationalId}" /></td>
							<td><span class="badge badge-pill badge-success"><a
									class=""
									href="${pageContext.request.contextPath }/familyInfo/detail?id=${family.familyId}">আরও
										দেখুন</a></span> <span class="badge badge-pill badge-warning"><a
									href="${pageContext.request.contextPath }/familyInfo/edit?id=${family.familyId}">এডিট</a></span>
							</td>
						</tr>
					</c:forEach>
				</table>

			</div>

			<div class="row">
				<c:if test="${totalPages>0}">

					<div class="pagination">
						<c:forEach var="i" begin="0" end="${totalPages-1}" step="1">
							<c:if test="${i == 0}">
								<a
									href="${pageContext.request.contextPath }/?_search=&_pageIndex=${i}&_rows=5&_sort=NA">&laquo;</a>
							</c:if>

							<c:if test="${i == pageIndex}">
								<a class="active"
									href="${pageContext.request.contextPath }/?_search=&_pageIndex=${i}&_rows=5&_sort=NA">${i+1}</a>
							</c:if>

							<c:if test="${i != pageIndex}">
								<a
									href="${pageContext.request.contextPath }/?_search=&_pageIndex=${i}&_rows=5&_sort=NA">${i+1}</a>
							</c:if>

							<c:if test="${i == totalPages}">
								<a
									href="${pageContext.request.contextPath }/country/show-all?_search=&_pageIndex=${i}&_rows=5&_sort=NA">&raquo;</a>
							</c:if>

						</c:forEach>
					</div>

				</c:if>
			</div>



		</div>


	</div>



</div>

<!-- GLOBAL FOOTER -->
<jsp:include page="common/footer.jsp" />





