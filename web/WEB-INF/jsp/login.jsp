<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java Express</title>
    </head>

    <body>
        <h1>Form Login</h1>
        <form:form action="${pageContext.request.contextPath}/admin/check" modelAttribute="LoginBean" method="POST" >
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
            <form:button name="submitButton" value="Submit">LOGIN</form:button>
        </form:form>
              <b>${errMsg}</b>
    </body>
</html>
