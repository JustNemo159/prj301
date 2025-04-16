<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><c:choose>
                <c:when test="${not empty plan.planID}">Edit Plan</c:when>
                <c:otherwise>Add Plan</c:otherwise>
            </c:choose></title>
    <link rel="stylesheet" href="dashboard.css">
    <style>
        .form-container {
            background-color: #f4f4f4;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: 20px auto;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .form-actions {
            text-align: right;
            margin-top: 20px;
        }
        .btn {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-weight: bold;
            text-decoration: none;
            display: inline-block;
        }
        .btn-save {
            background-color: #4CAF50;
            color: white;
        }
        .btn-cancel {
            background-color: #f44336;
            color: white;
            margin-left: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <h2>Dashboard</h2>
            <ul>
                <li><a href="home">Dashboard</a></li>
            <li><a href="product">Quản lý sản phẩm</a></li>
            <li><a href="employee">Quản lý công nhân</a></li>
            <li><a href="plan">Lập kế hoạch sản xuất</a></li>
            <li><a href="Attendance.jsp">Chấm công</a></li>
            <li><a href="logout">Đăng xuất</a></li>
            </ul>
        </div>

        <div class="main-content">
            <h1><c:choose>
                    <c:when test="${not empty plan.planID}">Edit Plan</c:when>
                    <c:otherwise>Add Plan</c:otherwise>
                </c:choose></h1>
            <div class="form-container">
                <form action="plan" method="post">
                    <input type="hidden" name="id" value="${plan.planID}" />

                    <div class="form-group">
                        <label for="name">Plan Name:</label>
                        <input type="text" id="name" name="name" value="${plan.planName}" required />
                    </div>

                    <div class="form-group">
                        <label for="startDate">Start Date:</label>
                        <input type="date" id="startDate" name="startDate" value="${plan.startDate}" required />
                    </div>

                    <div class="form-group">
                        <label for="endDate">End Date:</label>
                        <input type="date" id="endDate" name="endDate" value="${plan.endDate}" required />
                    </div>

                    <div class="form-group">
                        <label for="quantity">Quantity:</label>
                        <input type="number" id="quantity" name="quantity" value="${plan.quantity}" required />
                    </div>

                   

                    <div class="form-actions">
                        <button type="submit" class="btn btn-save">
                            <c:choose>
                                <c:when test="${not empty plan.planID}">Update Plan</c:when>
                                <c:otherwise>Add Plan</c:otherwise>
                            </c:choose>
                        </button>
                        <a href="plan" class="btn btn-cancel">Cancel</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>