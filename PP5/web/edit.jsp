<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.01.2020
  Time: 3:34
  To change this template use File | Settings | File Templates.
  &ndash;%&gt;--%>
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
    <input type = "text"  name="password" value = "<c:out value="${user.password}"/>"><br><br>
    <label>E-mail</label><br>
    <input type="text" name="email" value = "<c:out value="${user.email}"/>">    <br><br>
    <label>Role</label><br>
    <input type = "text"  name="role"  value = "<c:out value="${user.role}"/>"><br><br>
    <label>Age</label><br>
    <input type = "number"  name="age"  min="1" value = "<c:out value="${user.age}"/>"><br><br>

    <label>Пол если М то 1 если Ж то 0 </label><br>
    <input name="sex" type="number" min="0" max="1" value = "<c:out value="${user.sex?1:0}"/>"><br><br>
    <input type="hidden" name="id" value="${user.id}">
    <input type="hidden" name="name" value="${user.name}">
    <input type="hidden" name="password" value="${user.password}">
    <input type="hidden" name="email" value="${user.email}">
    <input type="hidden" name="age" value="${user.age}">
    <input type="hidden" name="role" value="${user.role}">
    <input type="hidden" name="sex" value="${user.sex}">
    <input type="submit" value="edit"/>
</form>


</body>
</html>
