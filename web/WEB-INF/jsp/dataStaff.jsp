<%-- 
    Document   : dataStaff
    Created on : Dec 29, 2017, 4:57:26 PM
    Author     : user
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Staff</title>
    </head>
    <body>
        <h1>Data Staff</h1>
        <jsp:include page="menu.jsp"></jsp:include>
        <c:forEach var="s" items="${staff}">
            <p>${s.getNamaLengkap()}</p>
        </c:forEach>
    </body>
</html>
