<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

    <h1>View games</h1>

    <c:if test="${not empty error }">
        <p class="error">${error} </p>
    </c:if>

    <form class="form-inline" action="Gameshop" method="get">
	
    <div class="form-group">
        <label for="choice">Choose:</label>
        <select name="choice" class="form-control" id="choice">
            <c:forEach var="b" items="${games }">
                <c:if test="${b.gameid eq param.choice }">
                    <option value="${b.gameid }" selected >${b.gamename }</option> 
                </c:if>
                <c:if test="${b.gameid ne param.choice }">
                    <option value="${b.gameid }" >${b.gamename }</option>
                </c:if>			
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
	
    </form>
	
    <p>
	
    <c:if test="${not empty agame }">
	
    <table class="table">
        <tr><td>ID: </td><td>${agame.gameid }</td></tr>
        <tr><td>Name: </td><td>${agame.gamename }</td></tr>
        <tr><td>Category: </td><td>${agame.category }</td></tr>
        <tr><td>Age: </td><td>${agame.age }</td></tr>
        <tr><td>Price: </td>
        <td><fmt:formatNumber value=" ${agame.price }" minFractionDigits="2" maxFractionDigits="2" /> €</td></tr>
        <tr><td>Picture: </td><td> <img height="150" src="${agame.gamepic}"> </td></tr>
    </table>
	
    </c:if>
	
    </p>
</div>

</body>
</html>