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
    Hello, <%= session.getAttribute( "owner" ) %><br>

    <a href="/addPhoto">Add photo</a>

    <a href="/sets">View all sets</a>

    <a href="/photos">View all photos</a><br>

</body>
</html>
