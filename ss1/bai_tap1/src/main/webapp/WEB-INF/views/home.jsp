

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Chuyển đổi USD sang VNĐ</title>
</head>
<body>
<h1>Chuyển đổi USD sang VNĐ</h1>

<c:if test="${not empty error}">
    <div style="color:red;">${error}</div>
</c:if>

<form action="${pageContext.request.contextPath}/convert" method="post">
    <div>
        <label for="rate">Tỉ giá (VNĐ / USD):</label>
        <input type="text" id="rate" name="rate" value="${rate}" />
    </div>
    <div>
        <label for="usd">Số USD:</label>
        <input type="text" id="usd" name="usd" value="${usd}" />
    </div>
    <div>
        <button type="submit">Chuyển đổi</button>
    </div>
</form>
</body>
</html>
