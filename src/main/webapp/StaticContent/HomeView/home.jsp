<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GramR</title>
</head>
<body>
<a href="/">Uitloggen</a>

<center>
    Hello <%= session.getAttribute("owner") %>.<br>

    <c:if test="${setId != null}">
        U beheert nu een set: ${setName}
    </c:if>

    <h2>1.1.4.4.1.1. gramR sets</h2>
    <a href="/sets">View all sets</a><br>

    <h2>1.1.4.5.1.1. gramR addphoto</h2>
    <a href="/addPhoto">Add photo</a><br>
    <a href="/searchPhoto">Search for photos</a><br>

    <h2>1.1.4.6.1.1. gramR applyfilter</h2>
    <a href="/photos">Filter toepassen op foto</a><br>
</center>
</body>
</html>
