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
					<h3>Form Create Product</h3>
					<hr/>
				</div>
				<div class="col-sm-12 col-md-3">
				</div>
				<div class="col-sm-12 col-md-9">
					<%@ include file="form.jsp" %>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../includes/footer.jsp" %>