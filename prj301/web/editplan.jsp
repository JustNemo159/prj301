<%-- 
    Document   : editplan
    Created on : Nov 1, 2024, 3:22:31 AM
    Author     : Admin
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><c:choose>
        <c:when test="${not empty plan.planID}">Edit Plan</c:when>
        <c:otherwise>Add Plan</c:otherwise>
    </c:choose></title>
    <link rel="stylesheet" href="dashboard.css">
</head>
<body>
<h2><c:choose>
    <c:when test="${not empty plan.planID}">Edit Plan</c:when>
    <c:otherwise>Add Plan</c:otherwise>
</c:choose></h2>
<form action="plan" method="post">
    <input type="hidden" name="id" value="${plan.planID}" />

    <label for="name">Plan Name:</label>
    <input type="text" id="name" name="name" value="${plan.planName}" required />
    <br><br>

    <label for="startDate">Start Date:</label>
    <input type="date" id="startDate" name="startDate" value="${plan.startDate}" required />
    <br><br>

    <label for="endDate">End Date:</label>
    <input type="date" id="endDate" name="endDate" value="${plan.endDate}" required />
    <br><br>

    <label for="quantity">Quantity:</label>
    <input type="number" id="quantity" name="quantity" value="${plan.quantity}" required />
    <br><br>

    <label for="departmentID">Department ID:</label>
    <input type="number" id="departmentID" name="departmentID" value="${plan.departmentID}" readonly />
    <br><br>

    <button type="submit">
        <c:choose>
            <c:when test="${not empty plan.planID}">Update Plan</c:when>
            <c:otherwise>Add Plan</c:otherwise>
        </c:choose>
    </button>
    <button type="button" onclick="window.location.href='plan'">Cancel</button>
</form>
</body>
</html>
