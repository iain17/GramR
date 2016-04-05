<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>GramR - Show sets</title>
</head>
<body>
<a href="/home">Terug</a>
<center>
    <h2>Show sets</h2>

    <c:if test="${setId != null}">
    <p>U beheert nu een set met setId: ${setId}
    </c:if>

    <table>
        <thead>
        <th>ID</th>
        <th>Owner</th>
        <th>Name</th>
        </thead>
        <tbody>
        <c:forEach items="${sets}" var="set">
            <tr>
                <td>
                    <form method="post">
                        <input type="hidden" name="setId" value="${set.id}">
                        <input type="submit" value="Beheren">
                    </form>
                </td>
                <td>
                    <c:out value="${set.owner}"/>
                </td>
                <td>
                    <c:out value="${set.name}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</center>
</body>
</html>
