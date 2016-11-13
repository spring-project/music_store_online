<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="- Card List"/>

<%@ include file="../includes/header.jsp" %>

<style>

</style>

<div class="container">
	<section>
		<div class="jumbotron">
			<h1>Card list</h1>
			<p>All the selected products in your shopping cart</p>
		</div>
	</section>
	<section ng-app="cartApp" ng-controller="cartCtrl" ng-init="initCart('${ cartId }')">

		<a class="btn btn-danger" ng-click="clearCart()">
			<span class="glyphicon glyphicon-remove-sign"></span>&nbsp;Clear Cart
		</a>
			
		<hr/>
		
		<div class="table-responsive">
			<table class="table table-hover">
				<tr>
					<th>Product</th>
					<th>Unit Price</th>
					<th>Quality</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				<tr ng-repeat="item in cart.cartItems">
					<td>{{ item.product.name }}</td>
					<td>{{ item.product.price }}</td>
					<td>{{ item.quality }}</td>
					<td>{{ item.totalPrice }}</td>
					<td>
						<a class="label label-danger" ng-click="removeFromCart(item.product.id)">
							<span class="glyphicon glyphicon-remove"></span>Remove
						</a>
					</td>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th>Grand Total</th>
					<th>{{ cart.grandTotal }}</th>
					<th></th>
				</tr>
			</table>
			<a href="<c:url value="/admin/products"/>" class="btn btn-default">Continue Shopping</a>
		</div>
	</section>
</div>

<script src="<c:url value="/resources/js/controllers.js"/>"></script>
<%@ include file="../includes/footer.jsp" %>