<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<form:form method="post" commandName="product">

		<div class="form-group">
			<form:label path="name">Name:</form:label>
		    <form:input path="name" class="form-control"/>
		</div>
		<div class="row">
		
			<div class="form-group col-md-4">
				<form:label path="price">Price:</form:label>
			    <form:input path="price" class="form-control" type="number"/>
			</div>
			
			<div class="form-group col-md-4">
				<label>Status:  </label><br/>
				<label class="inline-radio">
					<form:radiobutton path="status" value="0"/>
					<span>Active</span>
				</label>
				<label class="inline-radio">
					<form:radiobutton path="status" value="1"/>
					<span>Inactive</span>
				</label>
			</div>
			
			<div class="form-group col-md-4">
				<label>Condition:  </label><br/>
				<label class="inline-radio">
					<form:radiobutton path="condition" value="0"/>
					<span>New</span>
				</label>
				<label class="inline-radio">
					<form:radiobutton path="condition" value="1"/>
					<span>Used</span>
				</label>
			</div>
			
		</div>
		
		<div class="row">
			<div class="form-group col-md-6">
				<label>Category:</label>
			</div>
			<div class="form-group col-md-6">
				<form:label path="unitStock">Unit in Stock:</form:label>
			    <form:input path="unitStock" class="form-control" type="number"/>
			</div>
		</div>
		
		
		
		<div class="form-group">
			<label for="description">Description:</label>
		    <form:textarea path="description" class="form-control"></form:textarea>
		</div>
		
		<div class="form-group">
			<input type="submit" class="btn btn-primary" value="Submit">
			&nbsp;&nbsp;
			<a href="<c:url value="/admin/products" />" class="btn btn-default">Cancel</a>
		</div>
		
	</form:form>
