<%-- 
    Document   : admin
    Created on : Dec 28, 2017, 2:47:27 PM
    Author     : Jodi Noordiansyah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form:form action="admin/insert" modelAttribute="insertData" method="POST">
            <form:label path="namaPengirim">Nama Pengirim</form:label>
            <form:input path="namaPengirim"/><br/>
            <form:label path="teleponPengirim">No.Telepon</form:label>
            <form:input path="teleponPengirim"/><br/>
<!--            <form:label path="kotaPengirim">Kota</form:label>
            <form:input path="kotaPengirim"/><br/>-->

            <form:label path="kotaPengirim">Kota</form:label>
            <form:select path="kotaPengirim">
                <c:forEach var="c" items="${kota}">
                    <form:option path="kotaPengirim" value="${c.kodeKota}"> ${c.namaKota}</form:option>
                </c:forEach>
            </form:select><br/>

            <form:label path="alamatPengirim">Alamat</form:label>
            <form:textarea path="alamatPengirim"/><br/>
            <form:label path="namaPenerima">Nama Penerima</form:label>
            <form:input path="namaPenerima"/><br/>


            <form:label path="teleponPenerima">No.telepon</form:label>
            <form:input path="teleponPenerima"/><br/>

            <form:label path="kotaPenerima">Kota</form:label>
            <form:select path="kotaPenerima">
                <c:forEach var="c" items="${kota}">
                    <form:option path="kotaPenerima" value="${c.kodeKota}"> ${c.namaKota}</form:option>
                </c:forEach>
            </form:select><br/>

            <form:label path="alamatPenerima">Alamat</form:label>
            <form:textarea path="alamatPenerima"/><br/>
            <form:label path="tipePaket">Tipe Paket</form:label>
            <form:input path="tipePaket"/><br/>
            <form:label path="namaPaket">Nama Paket</form:label>
            <form:input path="namaPaket"/><br/>
            <form:label path="beratBarang">Berat Barang</form:label>
            <form:input path="beratBarang"/><br/>
            <form:label path="asuransi">Asuransi</form:label>
            <form:input path="asuransi"/><br/>
            <form:label path="hargaBarang">Harga Barang</form:label>
            <form:input path="hargaBarang"/><br/>
            <form:label path="jenisLayanan">Jenis Layanan</form:label>
            <form:input path="jenisLayanan"/><br/>
            <form:label path="tarif">Tarif</form:label>
            <form:input path="tarif"/><br/>
            <form:label path="totalTarif">Total Harga</form:label>
            <form:input path="totalTarif"/><br/>
            <form:label path="noResi">No. Resi</form:label>
            <form:input path="noResi"/><br/>
            <form:label path="createdBy">Created By</form:label>
            <form:input path="createdBy"/><br/>
            <form:label path="updatedBy">Updated By</form:label>
            <form:input path="updatedBy"/><br/>
            <form:label path="status">Status</form:label>
            <form:input path="status"/><br/>
            <form:button name="submitButton" value="submit">Submit</form:button>
        </form:form>
    </body>
</html>
