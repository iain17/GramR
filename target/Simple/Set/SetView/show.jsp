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
        U beheert nu een set met setId: ${setName}
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
                        <input type="hidden" name="action" value="manage">
                        <input type="hidden" name="setId" value="${set.id}">
                        <input type="hidden" name="setName" value="${set.name}">
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
    <form method="post">
        <input type="hidden" name="action" value="insert">
        <input type="text" name="name" placeholder="Set naam">
        <input type="submit" value="Toevoegen">
    </form>
</center>
</body>
</html>
