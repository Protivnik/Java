<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
<form>
    <input type="button" value="Add ROLE" onClick='location.href="/admin/addRole"'>
    <input type="button" value="Add user" onClick='location.href="/admin/add"'>
</form>
<table>
    <h3>User list</h3>
    <tr>
        <th>Name</th>
        <th>Password</th>
        <th>Age</th>
        <th>Role</th>

    </tr>
    <c:forEach var="users" items="${users}">
        <tr>
            <td>${users.name}</td>
            <td>${users.password}</td>
            <td>${users.age}</td>
            <td>
                <c:forEach items="${users.roles}" var="role">${role.role}; </c:forEach>
            </td>
            <td>
                <form method="get" action='<c:url value="admin/edit/${users.id}" />' style="display:inline;">
                    <input type="hidden" name="id" value="${users.id}">
                    <input type="submit" value="Edit">
                </form>
                *
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${users.id}">
                    <input type="submit" value="Delete">
                </form>
        </tr>
    </c:forEach>

</table>
<jsp:include page="logout.jsp"/>
</body>
</html>
