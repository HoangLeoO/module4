<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 27/11/2025
  Time: 2:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="add">
        <button type="button">
            Them moi
        </button>
    </a>

</div>
<table class="">
    <thead>
    <tr>
        <th>STT</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}" varStatus="stt">
        <tr>
            <td>${stt.count}</td>
            <td>
            <a href="detail?id=${customer.id}">
                ${customer.name}
            </a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
