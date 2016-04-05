<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //Session check:
    if (session.getAttribute("owner") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<html>
<head>
    <title>GramR - zoeken</title>
</head>
<body>
<a href="home.jsp">Terug</a>
<center>
    <h1>Zoeken</h1>
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
