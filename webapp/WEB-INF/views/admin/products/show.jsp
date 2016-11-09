<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="- Create"/>

<%@ include file="../includes/header.jsp" %>

<div class="container">
	<br/>
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="row1">
				<div class="col-sm-12">
					<h3>Form Detail Product</h3>
					<hr/>
				</div>
				<div class="col-sm-12 col-md-3">
				</div>
				<div class="col-sm-12 col-md-9">
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
					<div class="row">
						<div class="col-md-3">
							<a class="btn btn-sm btn-block btn-primary" href="<c:url value="/admin/products/edit/${ product.id }"/>">Edit this Product</a>
						</div>
						<div class="col-md-offset-6 col-md-3 text-right">
							<a class="btn btn-sm btn-block btn-default" href="<c:url value="/admin/products"/>">Back to Product list</a>
						</div>
					</div>
					<br/>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../includes/footer.jsp" %>