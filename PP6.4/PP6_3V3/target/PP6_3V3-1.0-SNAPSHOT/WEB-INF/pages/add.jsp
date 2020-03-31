<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <label>Age</label><br>
    <input name="age" type="number" min="1"><br><br>
    <label>Role</label><br>
    <p><b>Role</b></p>
    <c:forEach items="${roles}" var="role">
        <input type="checkbox" name="news" value="${role.id}" checked>${role.role}<Br>
    </c:forEach>



    <input type="submit" value="save"/>
</form>
</body>
</html>
