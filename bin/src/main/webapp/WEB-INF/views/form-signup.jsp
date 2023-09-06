<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome page</title>
</head>
<body>

<h1>Sign up Account</h1>

<form:form action="submit" method="post" modelAttribute="account">
    <table>
        <tr>
            <td><form:label path="username">Full Name: </form:label></td>
            <td><form:input path="username"/>
                <form:errors path="username" cssStyle="color:#d04c4c"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="password">Set your Password: </form:label></td>
            <td><form:password path="password"/>
                <form:errors path="password" cssStyle="color:red"/>
            </td>
        </tr>
        <tr>
            <c:if test="${not empty error}">
                Message: ${error}
            </c:if>
            <c:if  test="${not empty success}">
                Message: ${success}
            </c:if>
        </tr>
        <tr>
            <td><form:button>Submit</form:button></td>
        </tr>
    </table>
</form:form>

</body>
</html>
