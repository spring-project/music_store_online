<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="- Home"/>

<%@ include file="../includes/header.jsp" %>

<style>

</style>

<div class="container">
	<h1>Products Index</h1>
	
	<div class="row">
		<form action="<c:url value="/admin/products/search"/>">
			<div class="col-xs-6 col-md-4">
		 		<input type="text" name="key" value="${ key }" class="form-control input-sm"/>
		 	</div>
		 	
		 	<div class="col-xs-3 col-md-2">	
		 		<button type="submit" class="btn btn-sm btn-block btn-primary">Search</button>
			</div>
		
			<div class="col-xs-3 col-md-offset-4 col-md-2">
				<a href="<c:url value="/admin/products/new"/>" class="btn btn-sm btn-block btn-primary">New Product</a>
			</div>
		</form>
	</div>
	
	<hr/>
	
	<div class="table-responsive">
		<table class="table table-bordered table-striped table-hover table-sm">
			<thead>
				<tr>
					<th class="text-center">
						Id
					</th>
					<th>
						Image
					</th>
					<th class="text-center">
						Name
					</th>
					<th class="text-center">
						Price
					</th>
					<th class="text-center">
						Status
					</th>
					<th class="text-center">
						Action
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${ products }">
					<tr>
						<td>
							${ product.id }
						</td>
						<td>
							<c:if test="${ not empty product.imageName }">
								<img src="<c:url value="/resources/images/${ product.imageName }"/>" width="100px" height="50px"/>
							</c:if>
							<c:if test="${ empty product.imageName }">
								<img src="https://dummyimage.com/100x50/#2c3e5/fff.jpg" alt="No Image"/>
							</c:if>
						</td>
						<td>
							<a href="<c:url value="/admin/products/show/${ product.id }"/>">${ product.name }</a>
						</td>
						<td>
							${ product.price } USD
						</td>
						<td>
							${ product.status }
						</td>
						<td>
							<a href="<c:url value="/admin/products/edit/${ product.id }" />">
								<span class="glyphicon glyphicon-pencil"></span>
							</a>
							&nbsp;
							<a href="<c:url value="/admin/products/delete/${ product.id }" />">
								<span class="glyphicon glyphicon-trash"></span>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="../includes/footer.jsp" %>