<%-- 
    Document   : attendence
    Created on : Nov 2, 2024, 1:33:13 AM
    Author     : Admin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Attendance Management</title>
    <link rel="stylesheet" type="text/css" href="dashboard.css">
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <!-- Thêm sidebar menu ở đây -->
        </div>
        <div class="main-content">
            <h1>Attendance Management</h1>
            
            <form action="attendance" method="post">
                <div class="form-group">
                    <label for="attendanceId">Attendance ID:</label>
                    <input type="number" id="attendanceId" name="attendanceId" required>
                </div>
                <div class="form-group">
                    <label for="schEmpId">Schedule Employee ID:</label>
                    <input type="number" id="schEmpId" name="schEmpId" required>
                </div>
                <div class="form-group">
                    <label for="quantity">Quantity:</label>
                    <input type="number" id="quantity" name="quantity" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="alpha">Alpha:</label>
                    <input type="number" id="alpha" name="alpha" step="0.01" required>
                </div>
                <div class="form-actions">
                    <input type="submit" value="Add Attendance" class="btn-submit">
                </div>
            </form>

            <h2>Attendance List</h2>
            <table>
                <thead>
                    <tr>
                        <th>Attendance ID</th>
                        <th>Schedule Employee ID</th>
                        <th>Quantity</th>
                        <th>Alpha</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="attendance" items="${attendanceList}">
                        <tr>
                            <td>${attendance.attendanceId}</td>
                            <td>${attendance.schEmpId}</td>
                            <td>${attendance.quantity}</td>
                            <td>${attendance.alpha}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <script>
        // Lấy giá trị alpha từ cookie (nếu có) và điền vào form
        window.onload = function() {
            var cookies = document.cookie.split(';');
            for(var i = 0; i < cookies.length; i++) {
                var cookie = cookies[i].trim();
                if (cookie.startsWith("alpha=")) {
                    document.getElementById("alpha").value = cookie.substring("alpha=".length, cookie.length);
                    break;
                }
            }
        }
    </script>
</body>
</html>