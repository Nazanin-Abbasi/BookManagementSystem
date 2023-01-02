<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 7/24/2021
  Time: 7:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
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
</body>
<div align="center">
<h2>Login</h2>
<form:form action="login" method="post" modelAttribute="loginRequest">
    <form:label path="username">Username:</form:label>
    <form:input path="username"/><br/>

    <form:label path="password">Password</form:label>
    <form:input path="password"/><br/>

    <form:button>Login</form:button>
</form:form>
</div>
</html>
