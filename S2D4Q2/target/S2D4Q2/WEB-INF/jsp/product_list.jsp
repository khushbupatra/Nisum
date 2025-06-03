<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Products</title></head>
<body>
<h2>Stationery Products</h2>
<a href="new">Add New Product</a>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Category</th><th>Price</th><th>Action</th></tr>
<c:forEach var="p" items="${products}">
<tr>
    <td>${p.id}</td>
    <td>${p.name}</td>
    <td>${p.category}</td>
    <td>${p.price}</td>
    <td>
        <a href="edit/${p.id}">Edit</a> |
        <a href="delete/${p.id}">Delete</a>
    </td>
</tr>
</c:forEach>
</table>
</body>
</html>
