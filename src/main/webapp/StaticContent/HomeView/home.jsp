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
    <p>U beheert nu een set met setId: ${setId}
        </c:if>

    <h2>Sequence diagram "Beheer sets"</h2>
    <a href="/sets">View all sets</a><br>

    <h2>Sequence diagram "Zoeken foto"</h2>
    <a href="/addPhoto">Add photo</a><br>
    <a href="/searchPhoto">Search for photos</a><br>

    <h2>Something else.</h2>
    <a href="/photos">View all photos</a><br>
</center>
</body>
</html>
