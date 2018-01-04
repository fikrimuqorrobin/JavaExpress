<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <title>Pengiriman Page</title>
    </head>
    <body>
        <h1 align="center">Pengiriman</h1>

<form:form >
            Nama Penerima : <form:input path="namaPenerima"></form:input> <br/>
            Alamat Penerima : <form:input path="alamatPenerima"></form:input> <br/>
            Kota Penerima :  <form:select path="kotaPenerima" items="${kotaAsal}"></form:select><br/>
            Telepon Penerima : <form:input path="teleponPenerima"></form:input> <br/>
            Nama Pengirim : <form:input path="namaPengirim"></form:input> <br/>
            Alamat Pengirim : <form:input path="alamatPengirim"></form:input> <br/>
            Kota Pengirim : <form:select path="kotaPengirim" items="${kotaTujuan}"></form:select><br/>
            Telepon Pengirim : <form:input path="teleponPengirim"></form:input>  <br/>
            Asuransi : <form:radiobutton path="asuransi" value="Y"/>Iya<form:radiobutton path="asuransi" value="T"/>Tidak <br/>
            Berat Barang :  <form:input path="beratBarang"></form:input> <br/>
            Harga Barang :  <form:input path="hargaBarang"></form:input> <br/>
            Jenis Layanan : <form:select path="jenisLayanan" items="${jenisLayanan}"></form:select><br/>
            Nama Paket : <form:input path="namaPaket"></form:input> <br/>
            Tipe Paket : <form:input path="tipePaket"></form:input> <br/>
            <form:button path="buttonInsertP">Submit</form:button> <br/>
        </form:form>


        
    </body>
</html>
