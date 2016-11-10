<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="- Update"/>

<%@ include file="../includes/header.jsp" %>

<div class="container">
	<br/>
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="row1">
				<div class="col-sm-12">
					<h3>Form Update Product</h3>
					<hr/>
				</div>
				<div class="col-sm-12 col-md-4">
					<br/>
					<c:if test="${ not empty product.imageName }">
						<img class="img-thumbnail" src="<c:url value="/resources/images/${ product.imageName }"/>"/>
					</c:if>
					<c:if test="${ empty product.imageName }">
						<img class="img-thumbnail" src="https://dummyimage.com/658x375/#2c3e5/fff.jpg" alt="No Image"/>
					</c:if>
				</div>
				<div class="col-sm-12 col-md-8">
					<%@ include file="form.jsp" %>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../includes/footer.jsp" %>