<%--
  Created by IntelliJ IDEA.
  User: Tanya
  Date: 07.11.2016
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form method="post" action="/login">
    <table align="center">
        <tr>
            <td>Login</td>
            <td><input type="text" name="login" required></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" required></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"></td>
        </tr>
        <tr>
            <td colspan="2">${message}</td>
        </tr>
        <tr>
            <td colspan="2"><a href="/registration">Зарегистрироваться</a></td>
        </tr>
    </table>
</form>
</body>
</html>
