<jsp:include page="template-top.jsp" />

<div class="page-header">
  <h1>View Customer Account:</h1>
</div>

<jsp:include page="error-list.jsp" />

<p>
		<table>
		    <tr>
				<td> Customer ID: </td>
				<td>${user.customer_id}</td>
			</tr>
			<tr>
				<td> Customer Name: </td>
				<td>${user.customer_id}</td>
			</tr>
			<tr>
				<td> First Name: </td>
				<td>${user.customer_id}</td>
			</tr>
			<tr>
				<td> Last Name: </td>
				<td>${user.customer_id}</td>
			</tr>
			<tr>
				<td> Address: </td>
				<td>${user.customer_id}</td>
			</tr>
			<tr>
				<td> City: </td>
				<td>${user.customer_id}</td>
			</tr>
			<tr>
				<td> State: </td>
				<td>${user.customer_id}</td>
			</tr>
			<tr>
				<td> Zip: </td>
				<td>${user.customer_id}</td>
			</tr>
			<tr>
				<td> Last Trading Day: </td>
				<td>${day}</td>
			</tr>
			<tr>
				<td> Cash Balance: </td>
				<td></td>
			</tr>
			<tr><td>&nbsp;  <td></tr>
			<tr><td>&nbsp;  <td></tr>
		</table>	
		
		<table border="1">
			<c:if test="${requestScope.userFundList!= null}">
				<tr>
					<th> Fund ID </th>
					<th> Shares</th>
					<th> Last Execute Date</th>
					<th> Last Price</th>
					<th> Value</th>
				</tr>
					<c:forEach items="${requestScope.userFundList}" var="userFund">
						<tr>
							<td>${userFund.fund_id}</td>
							<td>${userFund.shares}</td>
							<td>${userFund.price_date}</td>
							<td>${userFund.price}</td>
							<td>${userFund.price * userFund.shares}</td>
						</tr>
					</c:forEach>
				</c:if>
			<tr><td>&nbsp;  <td><td>&nbsp;  <td><td>&nbsp;  <td></tr>
			<tr><td>&nbsp;  <td><td>&nbsp;  <td><td>&nbsp;  <td></tr>
		</table>
		<table>
		    <tr><td>&nbsp;  <td></tr>
			<tr><td>&nbsp;  <td></tr>

		</table>
		<button type="button" class="btn btn-default btn-lg active">Back</button>
</p>

<jsp:include page="template-bottom.jsp" />
