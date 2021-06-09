<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <link type="text/css"
          href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet"/>
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
    <title>Add new meal</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Edit meal</h2>

<script>
    $(function () {
        $('input[name=datetime-local]').datepicker();
    });
</script>

<form method="POST" action='MealServlet' name="frmAddMeal">

    Meal Id: <input type="hidden" name="mealId" value="<c:out value="${meal.id}"/>">

    DateTime: <input
        type="datetime-local" name="dateTime"
        value="<c:out value="${meal.dateTime}" />"/> <br/>

    Description: <input
        type="text" name="description"
        value="<c:out value="${meal.description}" />"/> <br/>

    Calories: <input
        type="text" name="calories"
        value="<c:out value="${meal.calories}" />"/> <br/>

    <input type="submit" value="Save"/>
    <button type="button"><b>Cancel</b></button>
</form>
</body>
</html>