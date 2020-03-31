<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.03.2020
  Time: 1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<h2>Welcome User</h2>

<body>
<label>Name</label><br>
<td>${user.name}</td><br><br>

<label>Password</label><br>
<td>${user.password}</td><br><br>
<label>Age</label><br>
<td>${user.age}</td><br><br>

<jsp:include page="logout.jsp"/>
</body>
</html>
