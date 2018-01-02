<%-- 
    Document   : cektarif
    Created on : Jan 2, 2018, 10:22:29 AM
    Author     : user
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cek Tarif</title>
    </head>
    <body>
        <h1>Cek Tarif</h1>
        <form:form action="cektarif/tarif" modelAttribute="cekTarif" method="POST">
             <form:select path="kotaAsal">
                <c:forEach var="c" items="${kota}">
                    <form:option path="kotaAsal" value="${c.kodeKota}"> ${c.namaKota}</form:option>
                </c:forEach>
            </form:select> ke
              <form:select path="kotaTujuan">
                <c:forEach var="c" items="${kota}">
                    <form:option path="kotaTujuan" value="${c.kodeKota}"> ${c.namaKota}</form:option>
                </c:forEach>
            </form:select>
            <form:label path="beratBarang">Berat Barang</form:label>
            <form:input path="beratBarang"/>kg
            <form:button name="submitButton" value="submit">Cari</form:button>
             </form:form>
           
    </body>
</html>
