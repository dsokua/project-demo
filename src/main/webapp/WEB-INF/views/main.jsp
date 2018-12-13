<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
    .error
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
</head>
<body>
	<h1>Request for Healthcare Premium quotation</h1>

	<form:form method="post" modelAttribute="premiumRequest" action="quote">
		<table>
			<tr>
				<td><spring:message code="label.age" text="Age" /></td>
				<td><form:input path="age" type="number"/></td>
				<td><form:errors path="age" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.criteria" text="Criteria" /></td>
				<td><form:checkboxes items="${criterias}"
						path="healthcareCriteria" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.payment_type"
						text="Payment Type" /></td>
				<td><form:select path="healthcarePaymentTypeId">
						<form:options items="${paymentTypes}" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Request Quotation" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>