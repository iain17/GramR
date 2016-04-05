<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>GramR - foto toevoegen</title>
</head>
<body>
<a href="/home">Terug</a>
<center>
        <h1>Foto toevoegen</h1>

        <c:if test="${result}">
            <p>Foto is succesvol opgeslagen en toegevoegd.</p>
        </c:if>

        <c:if test="${result != null && !result}">
          <p>Foto is niet opgeslagen!</p>
        </c:if>

        <form method="post">
            <label>Creator:</label>
            <input type="text" name="creator" required maxlength="32"><br>

            <label>Title:</label>
            <input type="text" name="title" required maxlength="32"><br>

            <label>URL:</label>
            <input type="url" name="url" required maxlength="32"><br>

            <label>Description:</label>
            <textarea name="description" required maxlength="32"></textarea><br/>

            <input type="submit" value="Foto toevoegen">
        </form>
    </center>
</body>
</html>