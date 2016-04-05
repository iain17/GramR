<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>GramR - zoeken</title>
</head>
<body>
<a href="/home">Terug</a>
<center>
    <h1>Zoeken</h1>


    <c:if test="${actionResult != null}">
        <%--<c:if test="${action == \"addPhotoToCurrentSet\"}">--%>

            <c:if test="${actionResult}">
                De geselecteerde foto is succesvol toegevoegd aan het set.
            </c:if>

            <c:if test="${!actionResult}">
                Er ging iets fout. De geselecteerde foto is niet toegevoegd aan het set.
            </c:if>

        <%--</c:if>--%>
    </c:if>

    <form method="get">
        <input type="text" placeholder="Zoekterm" style="width: 50%;" name="photo" required/><br><br>
        <input type="submit" value="Zoeken"/>
    </form>
    <table style="width: 50%">
        <thead>
        <th>Creator</th>
        <th>Title</th>
        <th>Url</th>
        <th>Description</th>
        <th>Sets</th>
        <th>Acties</th>
        </thead>
        <tbody>
        <c:forEach items="${photos}" var="photo">
            <tr>
                <td>
                    <c:out value="${photo.creator}"/>
                </td>
                <td>
                    <c:out value="${photo.title}"/>
                </td>
                <td>
                    <c:out value="${photo.url}"/>
                </td>
                <td>
                    <c:out value="${photo.description}"/>
                </td>
                <td>
                    <%
                </td>
                <td>
                    <c:if test="${setId != null}">
                        <form method="post">
                            <input type="hidden" name="setId" value="${setId}">
                            <input type="hidden" name="photoId" value="${photo.id}">
                            <input type="hidden" name="action" value="addPhotoToCurrentSet">
                            Open: <input type="checkbox" name="open" value="1">
                            <input type="submit" value="Toevoegen aan set: ${setName}">
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${photos.size() == 0}">
    <p>Geen zoekresultaten gevonden
    <p>
        </c:if>

</center>

</body>
</html>
