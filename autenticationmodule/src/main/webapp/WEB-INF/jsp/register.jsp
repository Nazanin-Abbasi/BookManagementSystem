<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 7/24/2021
  Time: 6:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <style type="text/css">
        label {
            display: inline-block;
            width: 200px;
            margin: 5px;
            text-align: left;
        }
        input[type=text], input[type=password], select {
            width: 200px;
        }
        input[type=radio] {
            display: inline-block;
            margin-left: 45px;
        }
        input[type=checkbox] {
            display: inline-block;
            margin-right: 190px;
        }

        button {
            padding: 10px;
            margin: 10px;
        }
    </style>
</head>
<body>
<div align="center">
    <h2>User Registration</h2>
    <form:form action="register" method="post" modelAttribute="registerRequest">
        <form:label path="firstName">First Name:</form:label>
        <form:input path="firstName"/><br/>

        <form:label path="lastName">Last Name:</form:label>
        <form:input path="lastName"/><br/>

        <form:label path="nationalNo">National Number:</form:label>
        <form:input path="nationalNo"/><br/>

        <form:label path="username">Username:</form:label>
        <form:input path="username"/><br/>

        <form:label path="password">Password</form:label>
        <form:input path="password"/><br/>

        <form:button>Register</form:button>
    </form:form>

</div>
</body>
</html>
