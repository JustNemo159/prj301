<%-- 
    Document   : plan
    Created on : Oct 31, 2024, 6:13:15 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Production Dashboard</title>
    <link rel="stylesheet" href="dashboard.css">
</head>
<body>

<div class="container">
    <!-- Navigation Sidebar -->
    <div class="sidebar">
        <h2>ABC Company</h2>
        <ul>
            <li><a href="home">Dashboard</a></li>
            <li><a href="product">Quản lý sản phẩm</a></li>
            <li><a href="employee">Quản lý công nhân</a></li>
            <li><a href="plan">Lập kế hoạch sản xuất</a></li>
            <li><a href="Attendance.jsp">Chấm công</a></li>
            <li><a href="logout">Đăng xuất</a></li>
        </ul>
    </div>

    <!-- Main Content -->
    <div class="main-content">
        <h1>Plan Manager</h1>

        <!-- Add Employee Button -->
        <div class="button-container">
            <a href="plan?action=add" class="add-button">Thêm kế hoạch</a>
        </div>
        <!-- Form Tìm Kiếm -->
        <div class="search-container">
            <form action="plan" method="get">
                <input type="text" name="searchName" placeholder="Nhập kế hoạch" required>
                <button type="submit">Tìm kiếm</button>
            </form>
        </div>

        <!-- Table for Employee List -->
        <div class="recent-activity">
            <h2>Danh sách kế hoạch</h2>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Start</th>
                    <th>End</th>
                    <th>Quantity</th>


                </tr>
                </thead>
                <tbody>
                <c:forEach var="pList" items="${requestScope.pList}" varStatus="loop">
                    <tr>
                        <td>${pList.planID}</td>
                        <td>${pList.planName}</td>
                        <td>${pList.startDate}</td>
                        <td>${pList.endDate}</td>
                        <td>${pList.quantity}</td>
                        <td>
                            <a href="plan?action=edit&id=${pList.planID}" class="edit-button">Sửa</a>
                            <a href="plan?action=delete&id=${pList.planID}" class="delete-button" onclick="return confirm('Bạn có chắc chắn muốn xóa công nhân này?');">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
