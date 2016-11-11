<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../includes/header.jsp" %>

<div class="container">
	
	<br/>
	<div class="panel panel-default">
		<div class="panel-body">
			<h1>Admin/Index</h1>
			<hr/>
			<c:if test="${ pageContext.request.userPrincipal.name != null }">
			<p>
				Welcome ${ pageContext.request.userPrincipal.name }
				${ pageContext.request.remoteUser }
			</p>
			<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
			</c:if>
		</div>
	</div>
	
</div>

<%@ include file="../includes/footer.jsp" %>