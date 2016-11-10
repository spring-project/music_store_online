<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<form:form method="post" commandName="product" enctype="multipart/form-data">

		<c:set var="unitStockError">
			<form:errors path="unitStock"/>
		</c:set>

		<spring:bind path="name">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="name">Name:</form:label>
		    <form:input path="name" class="form-control"/>
		    <form:errors path="name" cssClass="help-block"/>
		</div>
		</spring:bind>
		
		<div class="row">
			<spring:bind path="price">
			<div class="form-group ${status.error ? 'has-error' : ''} col-md-4">
				<form:label path="price">Price:</form:label>
			    <form:input path="price" class="form-control" type="number"/>
			    <form:errors path="price" cssClass="help-block"/>
			</div>
			</spring:bind>
			
			<spring:bind path="status">
			<div class="form-group ${status.error ? 'has-error' : ''} col-md-4">
				<label>Status:  </label><br/>
				<label class="inline-radio">
					<form:radiobutton path="status" value="0"/>
					<span>Active</span>
				</label>
				<label class="inline-radio">
					<form:radiobutton path="status" value="1"/>
					<span>Inactive</span>
				</label>
				<form:errors path="status" cssClass="help-block"/>
			</div>
			</spring:bind>
			
			
			<spring:bind path="condition">
			<div class="form-group ${status.error ? 'has-error' : ''} col-md-4">
				<label>Condition:  </label><br/>
				<label class="inline-radio">
					<form:radiobutton path="condition" value="0"/>
					<span>New</span>
				</label>
				<label class="inline-radio">
					<form:radiobutton path="condition" value="1"/>
					<span>Used</span>
				</label>
				<form:errors path="condition" cssClass="help-block"/>
			</div>
			</spring:bind>
			
		</div>
		
		<div class="row">
			<div class="form-group col-md-6">
				<label>Category:</label>
			</div>
			<div class="form-group ${ not empty unitStockError ? 'has-error' : '' } col-md-6">
				<form:label path="unitStock">Unit in Stock:</form:label>
			    <form:input path="unitStock" class="form-control" type="number"/>
			    ${ unitStockError }
			</div>
		</div>
		
		<div class="form-group">
			<label for="description">Description:</label>
		    <form:textarea path="description" class="form-control" placeholder="Decribe about this product"></form:textarea>
		</div>
		
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="image">Image:</form:label>
		    <form:input path="image" class="form-control" type="file"/>
		</div>

		<div class="form-group">
			<input type="submit" class="btn btn-primary" value="Submit">
			&nbsp;&nbsp;
			<a href="<c:url value="/admin/products" />" class="btn btn-default">Cancel</a>
		</div>
		
	</form:form>
