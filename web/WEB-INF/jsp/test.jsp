<%-- 
    Document   : test
    Created on : Dec 28, 2017, 4:33:58 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@taglib  prefix="list" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        <h1>Hello World!</h1>
        <list:forEach items="${list}" var="a">
            kota : ${a.createdTime} <br/>
        </list:forEach>
    </body>
</html>
