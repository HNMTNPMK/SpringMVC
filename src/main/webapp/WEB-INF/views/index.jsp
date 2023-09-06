<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>
<a href="${pageContext.request.contextPath}/product/add" type="button">Thêm sản phẩm</a>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
    </tr>

    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td><a href="${pageContext.request.contextPath}/product/${product.id}">View</a></td>
            <td><a href="${pageContext.request.contextPath}/product/update/${product.id}">Edit</a></td>
            <td><a href="${pageContext.request.contextPath}/product/delete/${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
