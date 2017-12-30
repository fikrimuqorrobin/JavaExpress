<%-- 
    Document   : DataTarif
    Created on : Dec 30, 2017, 2:04:55 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Tarif</title>
    </head>
    <body>
        <div>
            <H1>Data Tarif</H1>
            <table border="1px">
                <tr>
                    <th>ID Tarif</th>
                    <th>Kota Asal</th>
                    <th>Kota Tujuan</th>
                    <th>Reguler</th>
                    <th>Kilat</th>
                    <th>ONS</th>
                    <th>SDS</th>
                    <th>HDS</th>
                    <th>Created By</th>
                    <th>Created Time</th>
                    <th>Update By</th>
                    <th>Update Time</th>
                    <th>Status</th>
                </tr>
                <c:forEach var="x" items="${tarif}">
                    <tr>
                        <td>${x.idTarif}</td>
                        <td>${x.kotaAsal}</td>
                        <td>${x.kotaTujuan}</td>
                        <td>${x.reguler}</td>
                        <td>${x.kilat}</td>
                        <td>${x.ons}</td>
                        <td>${x.sds}</td>
                        <td>${x.hds}</td>
                        <td>${x.createdBy.getNamaLengkap()}</td>
                        <td>${x.createdTime}</td>
                        <td>${x.updatedBy.getNamaLengkap()}</td>
                        <td>${x.updatedTime}</td>
                        <td>${x.status.getStatus()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
