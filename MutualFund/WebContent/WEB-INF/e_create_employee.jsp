<jsp:include page="template-top2.jsp" />

<div class="page-header">
	<h1>Create Employee Account</h1>
</div>

<jsp:include page="error-list.jsp" />

<p>
<form method="POST" action="e_create_employee.do">
	<table class="table table-hover">
		<tr>
			<td>Employee Name: *</td>
			<td><input type="text" name="userName" value="" /></td>
		</tr>
		<tr>
			<td>Password: *</td>
			<td><input type="text" name="password" value="" /></td>
		</tr>
		<tr>
			<td>First Name: *</td>
			<td><input type="text" name="firstName" value="" /></td>
		</tr>
		<tr>
			<td>Last Name: *</td>
			<td><input type="text" name="lastName" value="" /></td>
		</tr>

	</table>

	<br> <br> <br>


	<button type="submit" class="btn btn-primary btn-lg active">Submit</button>


</form>
</p>

<jsp:include page="template-bottom.jsp" />
