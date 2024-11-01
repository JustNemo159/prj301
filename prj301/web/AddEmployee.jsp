<%-- 
    Document   : AddEmployee
    Created on : Nov 2, 2024, 1:09:45 AM
    Author     : Admin
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm công nhân mới</title>
    <link rel="stylesheet" type="text/css" href="dashboard.css">
</head>
<body>
    <h2>Thêm công nhân mới</h2>
    <form action="employee?action=add" method="post">
        <div class="form-group">
            <label for="name">Tên:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="gender">Giới tính:</label>
            <select id="gender" name="gender">
                <option value="true">Nam</option>
                <option value="false">Nữ</option>
            </select>
        </div>
        <div class="form-group">
            <label for="address">Địa chỉ:</label>
            <input type="text" id="address" name="address" required>
        </div>
        <div class="form-group">
            <label for="dob">Ngày sinh:</label>
            <input type="date" id="dob" name="dob" required>
        </div>
        <div class="form-group">
            <label for="roleID">Vai trò ID:</label>
            <input type="number" id="roleID" name="roleID" required>
        </div>
        <div class="form-group">
            <label for="departmentID">Phòng ban ID:</label>
            <input type="number" id="departmentID" name="departmentID" required>
        </div>
        <div class="form-group">
            <label for="salary">Lương:</label>
            <input type="number" id="salary" name="salary" required>
        </div>
        <div class="form-actions">
            <input type="submit" value="Thêm" class="btn-submit">
            <a href="employee" class="btn-cancel">Hủy</a>
        </div>
    </form>
</body>
</html>
