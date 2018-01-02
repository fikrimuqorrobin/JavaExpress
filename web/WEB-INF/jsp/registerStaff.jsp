<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Register</h1>

<form:form action="${pageContext.request.contextPath}/admin/input/staff/save" method="post" modelAttribute="registerBean" >
    <form:label path="nama">Nama Lengkap</form:label>
    <form:input path="nama" required="true"></form:input><br/>
    <form:label path="username">Username</form:label>
    <form:input path="username" required="true"></form:input><br/>
    <form:label path="password">Password</form:label>
    <form:password path="password" required="true"></form:password><br/>
    <form:button name="submitButton" value="Submit">SAVE</form:button>
</form:form>