<h3>Ini Menu Admin Master</h3>
<ul>
    <li><a href="${pageContext.request.contextPath}/admin">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/staff">Data Staff</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/input/staff">Input Admin Staff</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/profil/${admin.getIdAdmin()}">My Profile</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/logout" onclick="return confirm('Yakin Logout ?')">Logout</a></li>
</ul>
