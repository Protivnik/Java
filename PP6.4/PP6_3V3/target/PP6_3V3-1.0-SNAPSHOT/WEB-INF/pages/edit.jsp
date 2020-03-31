<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.02.2020
  Time: 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>

<h2>Edit User</h2>

<form method="post" action='<c:url value="/admin/edit" />'>
    <label>Name</label><br>
    <input type="text" name="name" value="<c:out value="${user.name}"/>"> <br><br>
    <label>Password</label><br>
    <input type="text" name="password" value="<c:out value="${user.password}"/>"><br><br>
    <label>Age</label><br>
    <input type="number" name="age" min="1" value="<c:out value="${user.age}"/>"><br><br>
    <p><b>Role</b></p>
    <c:forEach items="${roles}" var="role">
        <input type="checkbox" name="news" value="${role.id}" checked>${role.role}<Br>
    </c:forEach>

    <input type="hidden" name="id" value="${user.id}">
    <input type="submit" value="edit"/>
</form>


</body>
</html>