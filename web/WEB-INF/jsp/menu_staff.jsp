<h3>Ini Menu Admin Staff</h3>
<ul>
    <li><a href="${pageContext.request.contextPath}/admin">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/input/pengiriman">Input Pengiriman</a></li>
    <li><a href="${pageContext.request.contextPath}/update/pengiriman">Update Status Pengiriman</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/profil/${admin.getIdAdmin()}">My Profile</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/logout" onclick="return confirm('Yakin Logout ?')">Logout</a></li>
</ul>