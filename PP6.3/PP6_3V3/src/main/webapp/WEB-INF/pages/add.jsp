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
    <label>Age</label><br>
    <input name="age" type="number" min="1"><br><br>

    <input type="submit" value="save"/>
</form>
</body>
</html>
