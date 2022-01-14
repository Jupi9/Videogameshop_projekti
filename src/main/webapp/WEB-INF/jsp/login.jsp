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

<title>Bookshop</title>
</head>
<body>

<!-- otetaan mukaan sivulle header-osa -->
<c:import url="header.jsp" charEncoding="UTF-8"></c:import>

<div class="container-fluid">
    <h2>Login</h2>
	
    <c:if test="${not empty error }">
        <p class="text-danger">${error }</p>
    </c:if>
	
	
    <form action="Login" method="post">
	
      
        <div class="form-group">
            <label for="loginuser">Username:</label>
            <input type="text" class="form-control" id="loginuser" name="loginuser" value="${param.loginuser}">
        </div>
        <div class="form-group">
            <label for="loginpass">Enter password:</label>
            <input type="password" class="form-control" id="loginpass" name="loginpass" value="${param.loginpass}">
        </div>
        
        <button type="submit" class="btn btn-default">Log in</button>
		
    </form>

</div>

</body>
</html>