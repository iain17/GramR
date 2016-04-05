<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //Session check:
    if (session.getAttribute("owner") == null) {
        response.sendRedirect("index.jsp");
    }

    if (request.getParameter("id") != null) {
        String id = request.getParameter("id");
        session.setAttribute("id", id);
    }
%>
<html>
<head>
    <title>GramR - Show sets</title>
</head>
<body>
<h1>GramR</h1>
<h2>Show sets</h2>

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
                    <input type="hidden" name="id" value="${set.id}">
                    <input type="submit" value="${set.id}">
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
</body>
</html>
