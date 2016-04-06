<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>GramR - Filter toepassen op foto</title>
</head>
<body>
<center>
    <h1>Filter toepassen op foto</h1>

    <table>
        <thead>
        <tr>
            <th>Creator</th>
            <th>Title</th>
            <th>URL</th>
            <th>Description</th>
            <th>Acties</th>
        </tr>
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
                    <a href="/photos?photoId=${photo.id}">Filter toepassen</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</center>
</body>
</html>
