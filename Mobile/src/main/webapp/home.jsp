<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title>ok</title>
</head>

<body>
<br>
<div class="container">
    <h3>Model of mobiles</h3>

    <div class="row">
        <table class="table table-striped table-bordered col-md-4">
            <thead>
            <tr class="active">
                <th>id</th>
                <th>Model</th>
                <th>Cost</th>
            </tr>
            </thead>
            <c:forEach items="${mobilesList}" var="mobile">
                <tr>
                    <td>${mobile.getId()}</td>
                    <td>${mobile.getModel()}</td>
                    <td>${mobile.getCost()}</td>
                    <td><a href="${pageContext.request.contextPath}/edit?id=${mobile.getId()}&model=${mobile.getModel()}&cost=${mobile.getCost()}">Edit</a></td>
                    <td><a href="${pageContext.request.contextPath}/delete?id=${mobile.getId()}&model=${mobile.getModel()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <form action="${pageContext.request.contextPath}/add">
        <button class="btn btn-info" type="submit">add mobile</button>
    </form>
</div>
</body>
</html>
