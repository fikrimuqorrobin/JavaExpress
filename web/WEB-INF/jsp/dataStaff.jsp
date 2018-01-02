
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Data Staff</h1>
<table>
    <thead>
        <tr>
            <th>No</th>
            <th>Nama Staff</th>
            <th>Option</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach varStatus="no" var="s" items="${staff}">
            <tr>
                <td>${no.count}</td>
                <td>${s.getNamaLengkap()}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/profil/${s.getIdAdmin()}">Edit</a>
                    <a href="${pageContext.request.contextPath}/admin/hapus/staff/${s.getIdAdmin()}" onclick="return confirm('Yakin Akan Menghapus Data ?')">Hapus</a>
                </td>
            </tr>

        </c:forEach>

    </tbody>
</table>
