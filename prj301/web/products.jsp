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
        <h1>Product Manager</h1>

        <!-- Form Tìm Kiếm -->
        <div class="search-container">
            <form action="product" method="get">
                <input type="text" name="searchName" placeholder="Texxt here" required>
                <button type="submit">Tìm kiếm</button>
            </form>
        </div>

        <!-- Table for Employee List -->
        <div class="recent-activity">
            <h2>Danh sách sản phẩm</h2>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="pList" items="${requestScope.pList}" varStatus="loop">
                    <tr>
                        <td>${pList.productId}</td>
                        <td>${pList.productName}</td> 
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
