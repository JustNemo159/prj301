<%-- 
    Document   : EditEmployee
    Created on : Nov 1, 2024, 2:20:45 AM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
    <link rel="stylesheet" href="dashboard.css">
</head>
<body>

<div class="container">
    <!-- Main Content -->
    <div class="main-content">
        <h1>Chỉnh sửa thông tin công nhân</h1>

        <form action="employee" method="post">
            <!-- Hidden Field for Employee ID -->
            <input type="hidden" name="id" value="${employee.employeeID}" />

            <div class="form-group">
                <label for="name">Tên công nhân:</label>
                <input type="text" id="name" name="name" value="${employee.employeeName}" required>
            </div>

            <div class="form-group">
                <label for="gender">Giới tính:</label>
                <select id="gender" name="gender">
                    <option value="true" ${employee.gender ? 'selected' : ''}>Nam</option>
                    <option value="false" ${!employee.gender ? 'selected' : ''}>Nữ</option>
                </select>
            </div>

            <div class="form-group">
                <label for="address">Địa chỉ:</label>
                <input type="text" id="address" name="address" value="${employee.employeeAddress}" required>
            </div>

            <div class="form-group">
                <label for="dob">Ngày sinh:</label>
                <input type="date" id="dob" name="dob" value="${employee.dob}" required>
            </div>
            <div class="form-group">
                <label for="salary">Lương:</label>
                <input type="number" id="salary" name="salary" value="${employee.salary}" required>
            </div>

            <div class="form-actions">
                <button type="submit" class="btn-submit">Lưu thay đổi</button>
                <a href="employee" class="btn-cancel">Hủy</a>
            </div>
        </form>
    </div>
</div>

</body>
</html>
