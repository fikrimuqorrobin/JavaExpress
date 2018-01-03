<%-- 
    Document   : LacakPengiriman
    Created on : 29-Dec-2017, 14:01:23
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tracking Paket</title>

    </head>
    <body>
        <h1>Lacak Pengiriman</h1>
        <!--<h1>${trackingtest.kodePengiriman}</h1>-->

        <form:form action="${pageContext.request.contextPath}/home/tracking" modelAttribute="trackingBean" method ="POST">
            <table>
                <tr>
                    <td><form:label path="nomorResi">Cek No resi</form:label></td>
                    <form:input path="nomorResi"/>
                    <form:button name="searchButton" value="submit">Cari</form:button>
                    <td><form:select path="nomorResi" style="width: 100%"></td> </form:select>
                    <c:forEach var="t" items="${trackingDAO.findbyNoResi()}">
                        
                        <form:option value="${idTracking}">${status_pengiriman}</form:option>
                    </c:forEach>
            </table>    

        </form:form>
        <table
    </body>
</html>