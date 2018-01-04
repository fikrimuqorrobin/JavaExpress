<%-- 
    Document   : tarif
    Created on : Jan 2, 2018, 11:12:46 AM
    Author     : user
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


    <h1 align="center"> Tarif Layanan dari ${kotaAsal.namaKota} ke ${kotaTujuan.namaKota}</h1>
    <h1 align="center"> ${berat.beratBarang} kg</h1>
    <div class="container">
        <div   class="col-sm-2">
            <table align="center" width="100%">
                <th>Reguler</th>
                <th>Kilat</th>
                <th>ONS</th>
                <th>HDS</th>
                <th>SDS</th>
<!--                <tr>
                    <td>Tarif Awal ${tarif.reguler} setelah ${berat.beratBarang} kg ${berat.beratBarang * tarif.reguler}</td>
                    <td>Tarif Awal ${tarif.kilat} setelah ${berat.beratBarang} kg ${berat.beratBarang * tarif.kilat}</td>
                    <td>Tarif Awal ${tarif.ons} setelah ${berat.beratBarang} kg ${berat.beratBarang * tarif.ons}</td>
                    <td>Tarif Awal ${tarif.hds} setelah ${berat.beratBarang} kg ${berat.beratBarang * tarif.hds}</td>
                    <td>Tarif Awal ${tarif.sds} setelah ${berat.beratBarang} kg ${berat.beratBarang * tarif.sds}</td>
                    </tr>-->
                <tr>
                    <td>Tarif Awal</td>
                    <td>Tarif Awal</td>
                    <td>Tarif Awal</td>
                    <td>Tarif Awal</td>
                    <td>Tarif Awal</td>
                </tr>
                <tr>
                    <td>${tarif.reguler}</td>
                    <td>${tarif.kilat}</td>
                    <td>${tarif.ons}</td>
                    <td>${tarif.hds}</td>
                    <td>${tarif.sds}</td>
                </tr>
                <tr>
                    <td>setelah ${berat.beratBarang} kg</td>
                    <td>setelah ${berat.beratBarang} kg</td>
                    <td>setelah ${berat.beratBarang} kg</td>
                    <td>setelah ${berat.beratBarang} kg</td>
                    <td>setelah ${berat.beratBarang} kg</td>
                </tr>
                <tr>
                    <td>${berat.beratBarang * tarif.reguler}</td>
                    <td>${berat.beratBarang * tarif.kilat}</td>
                    <td>${berat.beratBarang * tarif.ons}</td>
                    <td>${berat.beratBarang * tarif.hds}</td>
                    <td>${berat.beratBarang * tarif.sds}</td>
                    </tr>


            </table>
        </div>
    </div>
<!--                   <a href="${pageContext.request.contextPath}/cektarif">Kembali</a>-->
</html>
