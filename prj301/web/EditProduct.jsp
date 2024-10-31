<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
    <link rel="stylesheet" href="dashboard.css">
</head>
<body>

<div class="container">
    <!-- Main Content -->
    <div class="main-content">
        <h1>Chỉnh sửa thông tin sản phẩm</h1>

        <form action="product" method="post">
            <!-- Hidden Field for Product ID -->
            <input type="hidden" name="id" value="${product.productId}" />

            <div class="form-group">
                <label for="name">Tên sản phẩm:</label>
                <input type="text" id="name" name="name" value="${product.productName}" required>
            </div>

            <div class="form-group">
                <label for="price">Giá:</label>
                <input type="number" id="price" name="price" value="${product.price}" required>
            </div>

            <div class="form-group">
                <label for="description">Mô tả:</label>
                <textarea id="description" name="description" required>${product.description}</textarea>
            </div>

            <div class="form-actions">
                <button type="submit" class="btn-submit">Lưu thay đổi</button>
                <a href="product" class="btn-cancel">Hủy</a>
            </div>
        </form>
    </div>
</div>

</body>
</html>
