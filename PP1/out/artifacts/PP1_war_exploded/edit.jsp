<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.01.2020
  Time: 3:34
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
<c:forEach var ="users" items="${user}">
    <form method="post" action='<c:url value="/edit" />'>
    <label>Name</label><br>
    <input type="text" name="name" value = "${users.name}"> <br><br>
    <label>E-mail</label><br>
    <input type="text" name="email" value = "${users.email}"><br><br>
    <label>Age</label><br>
    <input type = "number"  name="age"  min="1" value = "${users.age}"><br><br>

    <label>Пол если М то 1 если Ж то 0 </label><br>
    <input name="sex" type="number" min="0" max="1" value = "${users.sex?1:0}"><br><br>
        <input type="hidden" name="id" value="${users.id}">
        <input type="hidden" name="name" value="${users.name}">
        <input type="hidden" name="email" value="${users.email}">
        <input type="hidden" name="age" value="${users.age}">
        <input type="hidden" name="sex" value="${users.sex}">
    <input type="submit" value="edit"/>

</form>
</c:forEach>

</body>
</html>
