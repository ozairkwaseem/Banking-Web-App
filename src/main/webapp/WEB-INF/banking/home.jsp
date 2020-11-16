<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
		<link rel="stylesheet" href="css/main.css" />
		<meta charset="ISO-8859-1">
	<title>Personal Banking!!</title>
</head>
	<body>
	<style>
	body{
	background-image: url("https://thumbs.dreamstime.com/z/dollar-sign-seamless-pattern-white-background-vector-dollar-sign-seamless-pattern-white-background-115417825.jpg");
	}
	</style>
		<div class="container">
		<h1>Personal Banking Home Page</h1>
		
			<h2>Welcome, ${ user.firstName }</h2>
			<hr />
			<div class="new-idea float float-left">
		<table class="table table-dark table-hover">
<thead>
<tr>
<td>Checking Account Balance</td>
<td>Savings Account Balance</td>
<td>Account Owner</td>					
					</thead>
					<tbody>
					<c:forEach items="${ bankaccounts }" var="bankaccounts">
						<tr>
							<td>${ bankaccounts.checkingBalance }</td>
							<td>${ bankaccounts.savingsBalance }</td>	
							<td> ${bankaccounts.bankuser.firstName}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>

</table>

		
		<a href="/home/createform">Create Bank Account	
			<br>
		<a href="/home/update">Withdraw or Deposit Money	
		<br>	
		
			</div>
		</div>
	</body>
</html>