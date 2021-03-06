<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="auth" value="${ pageContext.request.userPrincipal }"/>
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value="/"/>">Music Store Online</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="${ fullPath.contains('admin/index') ? 'active' : '' }">
                	<a href="<c:url value="/admin"/>">Home</a>
                </li>
                <li class="${ fullPath.contains('admin/products/index') ? 'active' : '' }">
                	<a href="<c:url value="/admin/products"/>">Product</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
            	<li class="dropdown">
                	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">
                		${ auth.name } <span class="caret"></span>
                	</a>
                	<ul class="dropdown-menu">
                  		<li>
                  			<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
						</li>
                	</ul>
              	</li>
          	</ul>
        </div>
    </div>