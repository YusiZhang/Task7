<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="template-top.jsp" />
<jsp:include page="error-list.jsp" />
<div>
	<h2>Create Fund</h2>
	<h3>Created Fund Confirmation</h3>
	<h5>Your fund has been created successfully</h5>
	<p>You have created ${fund} with a ticker as ${ticker}.</p>
	<table>
		<tr>
			<td colspan="2" align="right"><input type="button"
				value="create another fund" /> <input type="button"
				value="homepage" /></td>
		</tr>
	</table>
</div>

<jsp:include page="template-bottom.jsp" />