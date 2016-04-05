<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>GramR - Apply filter on {title}</title>
</head>
<body>
<h1>GramR</h1>
<h2>Apply filter on {title}</h2>

<form method="get">
    <label>Filter type:</label>
    <select name="filter" id="filter">
        <option value="gray">gray</option>
        <option value="vintage">vintage</option>
    </select>

    <input type="submit" value="Submit">
</form>
</body>
</html>
