<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<h3>Web Demo:</h3>
	<P><a href="<c:url value="web/main" />">Use /web/main</a></P>
	<h3>Rest Demo:</h3>
	<p> Use Post method with PremiumRequest param at /rest</p>
</body>
</html>