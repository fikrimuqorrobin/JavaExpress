<%-- 
    Document   : registerStaff
    Created on : Dec 29, 2017, 1:58:11 PM
    Author     : user
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Staff</title>
    </head>
    <body>
        <h1>Register</h1>
        <div name="menu">
            <jsp:include page="menu.jsp"></jsp:include>
            </div>
        <form:form action="${pageContext.request.contextPath}/home/input/staff/save" method="post" modelAttribute="registerBean" >
            <form:label path="nama">Nama Lengkap</form:label>
            <form:input path="nama" required="true"></form:input><br/>
            <form:label path="username">Username</form:label>
            <form:input path="username" required="true"></form:input><br/>
            <form:label path="password">Password</form:label>
            <form:password path="password" required="true"></form:password><br/>
            <form:label path="level">Level</form:label>
            <form:select path="level">
                <c:forEach var="lvl" items="${level}">
                    <form:option value="${lvl.getIdLevel()}">${lvl.getLevel()}</form:option>
                </c:forEach>
            </form:select><br/>
            <form:button name="submitButton" value="Submit">SAVE</form:button>
        </form:form>

    </body>
</html>
