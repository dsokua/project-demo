<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quote</title>
</head>
<body>
	<h1>Healthcare Premium quotation:</h1>
	<p>${premium.rate}${premium.paymentType} payments</p>

	<P><a href="<c:url value="main" />">Back</a></P>
</body>
</html>