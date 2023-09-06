<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Detail</title>
</head>
<body>
<h1>Product Detail</h1>
<h2>${product.id}</h2>
<h2>${product.name}</h2>
<p>Price: ${product.price}</p>

<a href="${pageContext.request.contextPath}/Home">Back to Product List</a>
</body>
</html>
