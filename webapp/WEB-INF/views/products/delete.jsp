<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="pageTitle" value="- Delete"/>

<%@ include file="../includes/header.jsp" %>

<div class="container">
	<br/>
	<div class="panel panel-default">
		<div class="panel-body">
			<div>
				<div class="col-sm-12">
					<h3>Form Delete Product</h3>
					<hr/>
				</div>
				<div class="col-sm-12">
					
					<form:form method="post" commandName="product">
				
						<div class="text-center">
							<p>Do you really want to delete this product ?</p>
							<p>Product ( id = ${ product.id }, name = ${ product.name } )</p>
						</div>
						
						<div class="row">
							<br/>
							<div class="col-md-offset-8 col-md-2">
								<input type="submit" class="btn btn-block btn-primary" value="Yes">
							</div>
							
							<div class="col-md-2">
								<a href="<c:url value="/admin/products" />" class="btn btn-block btn-default">No</a>							
							</div>
						</div>
						
						<br/>
						
					</form:form>

				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../includes/footer.jsp" %>