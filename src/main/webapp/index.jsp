<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<form action="hello-servlet">
    <label>Email or Username: </label>
    <input type="text" name="data" required><br>
    <label for="password">Password: </label>
    <input type="password" id="password" name="password" required><br>
    <input type="submit" value="Login">
    <a href="register.jsp">Register </a>
</form>
</body>
</html>