<%-- 
    Document   : SelectPengiriman
    Created on : Dec 30, 2017, 6:14:15 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@taglib  prefix="list" uri="http://java.sun.com/jsp/jstl/core"%>
    </head>
    <body>
        <list:forEach items="${list}" var="a">
            ID Pengiriman : ${a.getIdPengiriman()}|| Nomor Resi : ${a.getNoResi()} || Nama Penerima : ${a.getNamaPenerima()} || Nama Pengirim : ${a.getNamaPengirim()}|| Total Tarif : ${a.getTotalTarif()} || Status : <a href="StatusPengiriman?status=${a.getStatus().getStatus()}&ID=${a.getIdPengiriman()}">${a.getStatus().getStatus()}</a>
            <br/>
        </list:forEach>
    </body>
</html>
