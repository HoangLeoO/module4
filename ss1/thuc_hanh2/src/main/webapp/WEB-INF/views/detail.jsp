<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 27/11/2025
  Time: 2:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="customer-info-container">
    <form action="edit" method="get">


        <h2>Customer Information</h2>
        <p>
            <strong>Id:</strong>
            <input type="text" name="id" value="${customer.id}" readonly>
        </p>
        <p>
            <strong>Name:</strong>
            <input type="text" name="name" value="${customer.name}">
        </p>
        <p>
            <strong>Email:</strong>
            <input type="date" name="date" value="${customer.date}">
        </p>
        <p>
            <strong>Address:</strong>
            <input type="text" name="address" value="${customer.address}">
        </p>
        <button type="submit">Update</button>
    </form>
</div>
</body>
</html>