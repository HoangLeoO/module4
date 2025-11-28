<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
<form action="greeting">
    <input type="text" name="name" placeholder="Enter your name">
    <input type="submit" value="Submit">
</form>
<h1>Hello, ${name}!</h1>
</body>
</html>
