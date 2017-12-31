<%-- 
    Document   : UpdateTarif
    Created on : Dec 30, 2017, 7:12:28 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <h1>Update Data Kota</h1>
            <form:form action="${pageContext.request.contextPath}/home/updateTarif/${atrb.idTarif}" modelAttribute="TarifBean" method="POST">
                <table>
                    <tr> 
                        <td><form:label path="kotaAsal">Kota Asal</form:label></td>
                        <td><form:input path="kotaAsal" value="${atrb.kotaAsal}" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="kotaTujuan">Kota Tujuan</form:label></td>
                        <td><form:input path="kotaTujuan" value="${atrb.kotaTujuan}" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="reguler">Harga Reguler</form:label></td>
                        <td><form:input path="reguler" value="${atrb.reguler}"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="kilat">Harga Kilat</form:label></td>
                        <td><form:input path="kilat" value="${atrb.kilat}"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="ons">Harga ONS</form:label></td>
                        <td><form:input path="ons" value="${atrb.ons}"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="sds">Harga SDS</form:label></td>
                        <td><form:input path="sds" value="${atrb.sds}"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="hds">Harga HDS</form:label></td>
                        <td><form:input path="hds" value="${atrb.hds}"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="createdBy">Create By</form:label></td>
                        <td><input type="text" value="${atrb.createdBy.getNamaLengkap()}"/>
                        <form:input path="createdBy" value="${atrb.createdBy.getIdAdmin()}" hidden="true"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="createdTime">Create Time</form:label></td>
                        <td><form:input path="createdTime" value="${atrb.createdTime}" readonly="true"/></td>
                    </tr>
                    <tr hidden="true">
                        <td><form:label path="updatedBy">Update By</form:label></td>
                        <td><form:input path="updatedBy" value="${atrb.updatedBy.getIdAdmin()}" readonly="true"/></td>
                    </tr>
                    <tr hidden="true">
                        <td><form:label path="status">Status</form:label></td>
                        <td><form:input path="status" value="${atrb.status.getIdStatus()}"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right">
                            <a href="${pageContext.request.contextPath}/home/kota">Kembali</a>
                            <form:button name="submitButton" value="Submit">Update</form:button>
                            </td>
                        </tr>
                    </table>
            </form:form>
        </div>
    </body>
</html>
