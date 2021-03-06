<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="template-top2.jsp" />
<jsp:include page="error-list.jsp" />

<div>
	<h1>Transition Day</h1>
	<div>
		<form action="e_transitionDay.do" method="POST">
			<table class="table">
				<tr>
					<td>Last trading day:</td>
					<td>${lastdate}</td>
				</tr>
				<tr>
					<td>Trading Day:</td>
					<td><input type="text" name="transitionDay"
						placeholder="later than last trading day value=" " /></td>
				</tr>
			</table>

			<table class="table table-hover">
				<thead>
					<tr>
						<th>FundName</th>
						<th>Ticker</th>
						<th class="text-right">Last Closing Price</th>
						<th class="text-right">New Closing Price</th>
					</tr>
				</thead>
				<tbody> <c:if test="${requestScope.funds!= null}">
					<c:forEach items="${requestScope.funds}" var="fund">
						<tr>
							<td>${fund.name}</td>
							<td>${fund.symbol}</td>
							<c:if test="${fund.price!=0}">
								<td align="right">$<fmt:formatNumber type="number" pattern="###,##0.00"
										value="${fund.price/100}" /></td>
							</c:if>
							<c:if test="${fund.price==0}">
								<td align="right">No price yet</td>
							</c:if>
							<td align="right"><input type="text" placeholder="0.00" name="price"
								value="" /> <input type="hidden" name="fund_id"
								value="${fund.fund_id }"></td>
						</tr>
					</c:forEach>
				</c:if> </tbody>

			</table>

			<input type="submit" class="btn btn-primary btn-lg active"
				name="submitCheck" value="Next">
		</form>
	</div>
</div>

<jsp:include page="template-bottom.jsp" />
