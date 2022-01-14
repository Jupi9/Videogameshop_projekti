<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

<title>Gameshop</title>
</head>
<body>

<!-- otetaan mukaan sivulle header-osa -->
<c:import url="header.jsp" charEncoding="UTF-8"></c:import>

<div class="container-fluid">
    <h2>Insert game</h2>
	
    <c:if test="${not empty error }">
        <p class="text-danger">${error }</p>
    </c:if>
	
	
    <form action="InsertGame" method="post">
	
        <div class="form-group">
            <label for="gamename">Name:</label>
            <input type="text" class="form-control" id="gamename" name="gamename" value="${param.gamename}">
        </div>
        <div class="form-group">
            <label for="category">Category:</label>
            <input type="text" class="form-control" id="category" name="category" value="${param.category}">
        </div>
        <div class="form-group">
            <label for="age">Age:</label>
            <input type="text" class="form-control" id="age" name="age" value="${param.age}">
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="text" class="form-control" id="price" name="price" value="${param.price}">
        </div>
        <div class="form-group">
            <label for="gamepic">Picture:</label>
            <input type="text" class="form-control" id="gamepic" name="gamepic" value="${param.gamepic}">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
		
    </form>

</div>

</body>
</html>