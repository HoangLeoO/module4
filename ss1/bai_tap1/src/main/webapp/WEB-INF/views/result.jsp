<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Kết quả chuyển đổi</title>
</head>
<body>
<h1>Kết quả chuyển đổi</h1>

<p>Tỉ giá: <span>${rate}</span> VNĐ / USD</p>
<p>Số USD: <span>${usd}</span> USD</p>
<p>Kết quả: <strong>
    <c:choose>
        <c:when test="${not empty vnd}">
            ${vnd} VNĐ
        </c:when>
        <c:otherwise>
            N/A
        </c:otherwise>
    </c:choose>
</strong></p>

<p><a href="${pageContext.request.contextPath}/home">Quay lại</a></p>
</body>
</html>
