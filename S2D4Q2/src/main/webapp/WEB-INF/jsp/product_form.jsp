<html>
<head><title>Product Form</title></head>
<body>
<h2>${product.id == 0 ? 'Add New' : 'Edit'} Product</h2>
<form action="save" method="post">
    <input type="hidden" name="id" value="${product.id}" />
    Name: <input type="text" name="name" value="${product.name}" required /><br/>
    Category: <input type="text" name="category" value="${product.category}" required /><br/>
    Price: <input type="number" step="0.01" name="price" value="${product.price}" required /><br/>
    <input type="submit" value="Save" />
</form>
</body>
</html>
