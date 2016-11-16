<%--
  Created by IntelliJ IDEA.
  User: Tanya
  Date: 07.11.2016
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form:form method="post" action="/registration/new" modelAttribute="user">
    <table align="center">
        <tr>
            <td>Login</td>
            <td><form:input path="login"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td>Firstname</td>
            <td><form:input path="firstname"/></td>
        </tr>
        <tr>
            <td>Lastname</td>
            <td><form:input path="lastname"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"></td>
        </tr>
        <tr>
            <td colspan="2">${message}</td>
        </tr>
        <tr>
            <td colspan="2"><a href="/">Авторизоваться</a></td>
        </tr>
    </table>
</form:form>
</body>
</html>
