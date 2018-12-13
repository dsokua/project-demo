<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Request for Healthcare Premium quotation</h1>

	<form action="quote" method="post">
		<p>
			Age: <input type="number" name="age" />
		</p>
		<p>Criteria:</p>
		<p>
			<form:checkboxes items="${criterias}" path="criterias"
				name="selectedCriterias" />
		</p>
		<p>Payment Type:</p>
		<form:select path="paymentTypes" name="paymentType" >


			<form:options items="${paymentTypes}" />

		</form:select>


		<p>
			<input type="submit" value="Request Quote" />
		</p>
	</form>
</body>
</html>