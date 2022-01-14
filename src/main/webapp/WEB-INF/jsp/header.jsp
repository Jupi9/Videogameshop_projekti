<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>Videogameshop</h1>
  <p>by Paavali & Juho</p> 
</div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li class="active"><a href="Gameshop">Home</a></li>
      <li><a href="InsertGame">Insert</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="Register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li>
         <c:if test="${empty user }">
      	   <a href="Login"><span class="glyphicon glyphicon-log-in"></span> Login</a>
         </c:if>
         <c:if test="${not empty user }">
      	   <a href="Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
         </c:if>
      </li>
    </ul>
  </div>
</nav> 