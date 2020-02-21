<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.01.2020
  Time: 6:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<h2>New User</h2>
<form method="post">
    <label>Name</label><br>
    <input name="name" type="text"><br><br>
    <label>Password</label><br>
    <input name="password" type="text"><br><br>
    <label>E-mail</label><br>
    <input name="email" type="text"><br><br>
    <label>Age</label><br>
    <input name="age" type="number" min="1"><br><br>
    <label>Role</label><br>
    <input name="role" type="text"><br><br>
    <label>Пол если М то 1 если Ж то 0 </label><br>
    <input name="sex" type="number" min="0" max="1"><br><br>
    <input type="submit" value="save"/>
</form>
</body>
</html>

