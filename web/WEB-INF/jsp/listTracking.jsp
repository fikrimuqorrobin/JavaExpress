<%-- 
    Document   : listTracking
    Created on : 04-Jan-2018, 09:36:37
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <thead>
            <th>No</th>
            <th>No Resi</th>
            <th>Waktu Pengiriman</th>
            <th>Status Pengiriman</th>
        </thead>
        <c:forEach var="d" items="${list}">
            <tbody>

            <td>${d.idTracking}</td>
            <td>${d.getKodePengiriman().getNoResi()}

            <td> ${d.getCreatedTime()}</td>
            <td> ${d.getStatusPengiriman()}</td>
        </tbody>
    </c:forEach>
</table>


</body>
</html>
