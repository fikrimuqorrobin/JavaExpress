<%-- 
    Document   : Tracking
    Created on : Dec 29, 2017, 10:11:19 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@taglib prefix="list" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    </head>
    <body>
        <list:forEach items="${list}" var="x">
            noResi : ${x}
            
        </list:forEach>
            
            <form:form modelAttribute="ft" action="Tracking" method="Post">
                <form:select items="${list}" path="noResi" ></form:select>
                <form:input path="statusPengiriman"></form:input>
                <form:button path="buttonSubmit"></form:button>
                
            </form:form>
    </body>
</html>
