<%-- 
    Document   : insertTarif
    Created on : Dec 29, 2017, 8:04:25 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    </head>
    <body>
        <form:form modelAttribute="ft" method="POST" action="insertTr">
            Kota Asal : <form:select path="kotaAsal" items="${kotaAsal}"></form:select><br/>
            Kota Tujuan : <form:select path="kotaTujuan" items="${kotaTujuan}"></form:select><br/>   
            Tarif Reguler : <form:input path="tarifReguler"></form:input>
            Tarif kilat : <form:input path="tarifKilat"></form:input>
            Tarif ons : <form:input path="tarifOns"></form:input>
            Tarif sds : <form:input path="tarifSds"></form:input>
            Tarif hds : <form:input path="tarifHds"></form:input>
            <form:button path="buttonInsert">Submit</form:button>
        </form:form>
    </body>
</html>
