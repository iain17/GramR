<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(request.getParameter( "owner" ) != null) {
        String owner = request.getParameter("owner");
        session.setAttribute("owner", owner);
    }

    //Session check:
    if(session.getAttribute( "owner" ) == null) {
        response.sendRedirect("index.jsp");
    }
%>
<html>
<head>
    <title>GramR</title>
</head>
<body>

    <a href="index.jsp">Uitloggen</a>

    <center>
        Hello, <%= session.getAttribute( "owner" ) %><br>

        <h2>Sequencediagram "Beheer sets"</h2>
        <a href="/sets">View all sets</a>

        <h2>Sequencediagram "Zoeken foto"</h2>
        <a href="/addPhoto">Add photo</a>
        <a href="/searchPhoto">Search for photos</a><br>

        <a href="/photos">View all photos</a><br>
    </center>

</body>
</html>
