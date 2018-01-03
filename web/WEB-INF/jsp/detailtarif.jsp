<%-- 
    Document   : tarif
    Created on : Jan 2, 2018, 11:12:46 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Tarif</title>
    </head>
    <body>
        
       <h1> Tarif Layanan dari ${kotaAsal.namaKota} ke ${kotaTujuan.namaKota}</h1>
       <h1> ${berat.beratBarang} kg</h1>
        <h1>Reguler</h1> Tarif Awal ${tarif.reguler} setelah ${berat.beratBarang} kg ${berat.beratBarang * tarif.reguler}
        
       <h1>Kilat</h1>Tarif Awal ${tarif.kilat} setelah ${berat.beratBarang} kg ${berat.beratBarang * tarif.kilat}
       
       <h1>ONS</h1>Tarif Awal ${tarif.ons} setelah ${berat.beratBarang} kg ${berat.beratBarang * tarif.ons}
       
       <h1>HDS</h1>Tarif Awal ${tarif.hds} setelah ${berat.beratBarang} kg ${berat.beratBarang * tarif.hds}
       
       <h1>SDS</h1>Tarif Awal ${tarif.sds} setelah ${berat.beratBarang} kg ${berat.beratBarang * tarif.sds}
       
       
    </body>
</html>
