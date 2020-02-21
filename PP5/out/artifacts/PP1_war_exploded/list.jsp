<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.01.2020
  Time: 8:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Таблица Юзеров</title>
</head>
<body>
<form>
    <input type="button" value="Add user" onClick='location.href="/admin/add"'>
</form>
<table>
    <h3>User list</h3>
    <tr>
        <th>Name</th>
        <th>Password</th>
        <th>Role</th>
        <th>E-mail</th>
        <th>Age</th>
        <th>Sex</th>
    </tr>
    <c:forEach var="users" items="${users}">
        <tr>
            <td>${users.name}</td>
            <td>${users.password}</td>
            <td>${users.role}</td>
            <td>${users.email}</td>
            <td>${users.age}</td>
            <td>${users.sex?'Men':'Women'}</td>
            <td>
                <form method="post" action='<c:url value="/admin/edit" />' style="display:inline;">
                    <input type="hidden" name="id" value="${users.id}">
                    <input type="submit" value="Edit">
                </form>
                *
                <form method="post" action='<c:url value="/admin/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${users.id}">
                    <input type="submit" value="Delete">
                </form>
        </tr>
    </c:forEach>

</table>
</body>
</html>
