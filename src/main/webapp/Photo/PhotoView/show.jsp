<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>GramR - Show photos</title>
</head>
<body>

<h1>GramR</h1>
<h2>Show photos</h2>

<table>
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
</body>
</html>