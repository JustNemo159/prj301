<%-- 
    Document   : dashboard
    Created on : Nov 1, 2024, 4:22:06 AM
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
    <h1>Dashboard</h1>

    <!-- Overview Cards -->
    <div class="overview">
      <div class="card">
        <h3>Sản lượng</h3>
        <p>Số lượng: <%= request.getAttribute("sccount") %></p>
      </div>
      <div class="card">
        <h3>Công nhân</h3>
        <p>Số lượng: <%= request.getAttribute("Ecount") %></p>
      </div>
      <div class="card">
        <h3>Kế hoạch sản xuất</h3>
        <p>Số kế hoạch: <%= request.getAttribute("pcount") %></p>
      </div>
      <div class="card">
        <h3>Báo cáo</h3>
        <p>Số báo cáo: 0</p>
      </div>
    </div>

    <!-- Table for Recent Activity -->
    <div class="recent-activity">
      <h2>Hoạt động gần đây</h2>
      <table>
        <thead>
        <tr>
          <th>Plan Name</th>
          <th>Plant Start</th>
          <th>Plant End</th>
          <th>Quantity</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="plan" items="${requestScope.Plist}" varStatus="loop">
          <tr>
            <td>${plan.planName}</td>
            <td>${plan.startDate}</td>
            <td>${plan.endDate}</td>
            <td>${plan.quantity}</td>
          </tr>
        </c:forEach>
        <!-- Add additional rows here with dynamic data -->
        </tbody>
      </table>
    </div>
  </div>
</div>

</body>
</html>
