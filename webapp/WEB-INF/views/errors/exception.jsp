<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="- Error"/>

<%@ include file="../includes/header.jsp" %>

<div class="container">
	<br/>
	<div class="panel panel-default">
		<div class="panel-body">
			<h3>You got some errors</h3>
			<hr/>
			<p><strong>${ name }</strong></p>
			<p><strong>${ message }</strong></p>
		</div>
	</div>
</div>

<%@ include file="../includes/footer.jsp" %>