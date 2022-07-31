<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="registration">
    <label>Name: </label>
    <input type="text" name="firstname" required><br>
    <label>Last Name: </label>
    <input type="text" name="lastname" required><br>
    <label>Email: </label>
    <input type="text" name="email" required><br>
    <label>Profession: </label>
    <input type="text" name="profession" required><br>
    <label>Username: </label>
    <input type="text" name="username" required><br>
    <label for="password">Password: </label>
    <input type="password" id="password" name="password" required><br>
    <label for="password">Repeat Password: </label>
    <input type="password" id="repeatedPassword" name="repeatedPassword" required><br>
    <input type="submit" value="Sign-up">
    <a href=index.jsp>back</a>
</form>
</body>
</html>
