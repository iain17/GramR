<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>GramR - Apply filter on {title}</title>
    <script>

        function applyFilter(select) {
            switch (select) {
                case "gray":
                    document.getElementById("grayDiv").style.display = "block";
                    document.getElementById("vintageDiv").style.display = "none";
                    break;
                case "vintage":
                    document.getElementById("grayDiv").style.display = "none";
                    document.getElementById("vintageDiv").style.display = "block";
                    break;
            }
        }

    </script>
</head>
<body>
<h1>GramR</h1>
<h2>Apply filter on {title}</h2>

<form method="post">
    <label>Filtertype:</label>
    <select name="filter" onchange="applyFilter(this.value)" required>
        <option></option>
        <option value="gray">gray</option>
        <option value="vintage">vintage</option>
    </select><br>

    <div id="grayDiv" style="display: none;">
        <label>Grijspercentage:</label>
        <input name="grayPercentage" min="0" max="100" type="number" value=""><br>
    </div>

    <div id="vintageDiv" style="display: none;">
        <label>X-coördinaat linksboven:</label>
        <input name="vintageUpperLeftX" min="0" type="number" value=""><br>

        <label>Y-coördinaat linksboven:</label>
        <input name="vintageUpperLeftY" min="0" type="number" value=""><br>

        <label>X-coördinaat rechtsonder:</label>
        <input name="vintageUpperRightX" min="1" type="number" value=""><br>

        <label>Y-coördinaat rechtsonder:</label>
        <input name="vintageUpperRightY" min="1" type="number" value=""><br>
    </div>

    <input type="submit" value="Submit">
</form>
</body>
</html>
