<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Order</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { max-width: 800px; margin: auto; padding: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .btn-add { display: inline-block; padding: 10px 15px; background-color: #007bff; color: white; text-decoration: none; border-radius: 4px; }
        .btn-add:hover { background-color: #0056b3; }
    </style>
</head>
<body>
<div class="container">
    <h2>Danh Sách Order</h2>
    <a href="add" class="btn-add">Thêm Order Mới</a>

    <c:choose>
        <c:when test="${empty orders}">
            <p>Không có Order nào được tìm thấy.</p>
        </c:when>
        <c:otherwise>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nước Sốt (Sauces)</th>
                    <th>Gia Vị (Seasoning)</th>
                    <th>Rau Củ (Veggies)</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td><c:out value="${order.id}"/></td>
                        <td><c:out value="${order.sauces}"/></td>
                        <td><c:out value="${order.seasoning}"/></td>
                        <td><c:out value="${order.veggies}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>