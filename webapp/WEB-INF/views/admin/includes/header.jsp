<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Music Store Online ${ pageTitle }</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>" />
		<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.js"></script>
		<script src="<c:url value="/resources/js/jquery-1.9.1.min.js"/>"></script>
		<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	</head>
<body>

	<c:set var="basePath" value="${pageContext.request.contextPath}" />
	<c:set var="fullPath" value="${pageContext.request.requestURI}" />
	
    <nav class="navbar navbar-inverse navbar-static-top" role="navigation" style="margin-bottom: 0px;">
    	<%@ include file="../includes/navbar.jsp"%>
	</nav>