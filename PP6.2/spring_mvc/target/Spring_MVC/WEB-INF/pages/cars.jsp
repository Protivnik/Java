<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>

    <head><title><spring:message code="carLeng"/></title></head>

</head>
<body>
<table>
    <h1><spring:message code="carLeng"/></h1>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>number</th>
    </tr>
    <c:forEach var="cars" items="${Cars}">
        <tr>
            <td>${cars.id}</td>
            <td>${cars.name}</td>
            <td>${cars.number}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>