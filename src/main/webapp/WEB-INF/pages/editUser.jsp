<%--
  Created by IntelliJ IDEA.
  User: Tanya
  Date: 08.11.2016
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Редактирование информации о пользователе</title>
</head>
<body>
<form:form action="/edit/save" method="post" modelAttribute="user" >
    <table align="center">
        <tr>
            <td>Login</td>
            <td><form:input path="login"/></td>
        </tr>
        <tr>
            <td>
                Firstname
            </td>
            <td><form:input path="firstname"/></td>

        </tr>
        <tr>
            <td>
                Lastname
            </td>
            <td>
                <form:input path="lastname"/></td>
            </td>
        </tr>
        <tr>
            <td>
                Email
            </td>
            <td>
                <form:input path="email" /></td>
            </td>

        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Сохранить изменения">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                ${message}
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
