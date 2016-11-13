<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../includes/header.jsp" %>

<div class="container">
	<h1>Login Page</h1>
	
	<c:if test="${ not empty message }">
		<div class="alert alert-info">
			${ message }
		</div>
	</c:if>
	
	<c:if test="${ not empty error }">
		<div class="alert alert-danger">
			${ error }
		</div>
	</c:if>
	
	<form method="post" action="<c:url value="/j_spring_security_check"/>">

		<div class="form-group">
			<label for="username">Username:</label>
		    <input type="text" name="username" class="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="password">Password:</label>
		    <input type="password" name="password" class="form-control"/>
		</div>
		
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
		
		<div class="form-group">
		    <input type="submit" value="Login" class="btn btn-primary"/>
		</div>
		
		
	</form>
</div>

<%@ include file="../includes/footer.jsp" %>