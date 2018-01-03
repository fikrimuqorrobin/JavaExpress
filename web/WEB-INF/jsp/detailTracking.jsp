<%-- 
    Document   : detailTracking
    Created on : 03-Jan-2018, 15:25:43
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${tracking}</h1>
        <table>
            <thead>
            <th>No Resi</th>
            <th>Service</th>
            <th>Tanggal Kirim</th>
            <th>Kota Asal</th>
            <th>Kota Tujuan</th>
            </thead>
            
            <tbody>
                <tr>
                    <td>${trackings.getNoResi()}</td>
                    <td> ${trackings.getJenisLayanan()}</td>
                    <td> <f:formatDate value="${trackings.getCreatedTime()}"/></td>
                    <td> ${trackings.getKotaPengirim().getNamaKota()}</td>
                    <td> ${trackings.getKotaPenerima().getNamaKota()}<td></tr>
            </tbody>
        </table>
            <table>
                 <tr>
                    <h1>History</h1>
                    </tr>
                    <tr>
                <c:forEach var="w" varStatus="s" items="${statustracking}">
                   
                        <td>${s.count}</td>
                        <td>
                           "${w.getCreatedTime()}"
                        </td>
                        <td>${w.getStatusPengiriman()}</td>
                    <tr>
                    
                </c:forEach>
            </table>
    </body>
</html>
