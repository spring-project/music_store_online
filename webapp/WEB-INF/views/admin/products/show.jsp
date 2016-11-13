<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="- Create"/>

<%@ include file="../includes/header.jsp" %>

<div class="container" ng-app="cartApp" ng-controller="cartCtrl">
	<br/>
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="row1">
				<div class="col-sm-12">
					<h3>Form Detail Product</h3>
					<hr/>
				</div>
				<div class="col-sm-12 col-md-4">
					<br/>
					<c:if test="${ not empty product.imageName }">
						<img class="img-thumbnail" src="<c:url value="/resources/images/${ product.imageName }"/> "/>
					</c:if>
					<c:if test="${ empty product.imageName }">
						<img class="img-thumbnail" src="https://dummyimage.com/338x236/#2c3e5/fff.jpg" alt="No Image" />
					</c:if>
				</div>
				<div class="col-sm-12 col-md-8">
					<h3>${ product.name }</h3>
					<p><b>$ ${ product.price }</b></p>					
					<p><b>Status:</b> ${ product.status }</p>
					<p><b>Category:</b> </p>					
					<p><b>Condition:</b> ${ product.condition }</p>
					<p><b>Manufacturer:</b> ${ product.manufacturer }</p>
					<div class="panel panel-default">
						<div class="panel-body">
							<p>${ product.description }</p>
						</div>
					</div>
				
					<p>
						<strong>Check the User role</strong> that change back link of 
						<strong>[ Back to Product list ]</strong> and <strong>[ Continues Shopping ]</strong></p>
						
					<div class="alert alert-success">
						<strong>Note: </strong>After you add product to cart, you should your cart.
					</div>						
				
					<c:set scope="page" var="role" value="${ param.role }"/>
					<c:set scope="page" var="link" value="/products"/>
					<c:if test="${ role == 'admin' }">
						<c:set scope="page" var="link" value="/admin/products"/>
					</c:if>
					
					<div class="row" ng-init="cartId = '${ cartId }'">
						<div class="col-xs-12 col-sm-3">
							<a class="btn btn-sm btn-block btn-success" ng-click="addToCart(${ product.id })">
								<span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;&nbsp;Add to cart
							</a>
						</div>
						<div class="col-xs-12 col-sm-3">
							<a class="btn btn-sm btn-block btn-warning" href="<c:url value="/admin/carts"/>">
								<span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;&nbsp;View cart
							</a>
						</div>
						<div class="col-xs-12 col-sm-3">
							<a class="btn btn-sm btn-block btn-primary" href="<c:url value="/admin/products/edit/${ product.id }"/>">Edit this Product</a>
						</div>
						<div class="col-xs-12 col-sm-3 text-right">
							<a class="btn btn-sm btn-block btn-default" href="<c:url value="${ link }"/>">Back to Product list</a>
						</div>
					</div>
					<br/>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="<c:url value="/resources/js/controllers.js"/>"></script>
<%@ include file="../includes/footer.jsp" %>