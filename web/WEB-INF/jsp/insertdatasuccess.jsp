<%-- 
    Document   : insertdatasuccess
    Created on : Dec 28, 2017, 3:34:27 PM
    Author     : Jodi Noordiansyah
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Berhasil</h1>
        <c:forEach var="c" items="${kota}">

                
                    <h2>${c.namaKota}</h2>
                    

                        </c:forEach>
    </body>
</html>
