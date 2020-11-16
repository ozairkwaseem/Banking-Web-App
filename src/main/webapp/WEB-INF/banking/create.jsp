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
	<title>New Bank Account</title>
</head>
	<body style="background-color:lightgreen;">
	
		<div class="container">
		
			<h2>Hello, ${ user.firstName }</h2>
		<h1>Lets Create Your New Account</h1>
			<hr/>
			<div class="new-idea float float-left">
			
				<form:form action="/home/createbankaccount" method="post" modelAttribute="bankaccounts">
					<form:hidden value="${ user.id }" path="bankuser"/>
						<div class="form-group">
						<form:label path="checkingBalance">Starting Checking Balance</form:label>
						<form:errors path="checkingBalance"/>
						<form:input class="form-control" path="checkingBalance"></form:input>
					</div>
					
					<div class="form-group">
						<form:label path="savingsBalance">Starting Savings Balance</form:label>
						<form:errors path="savingsBalance"/>
						<form:input class="form-control" path="savingsBalance"></form:input>
					</div>
  				 <button>Click to Create Your New Bank Account!</button>				    
			</form:form>
			</div>
		
						
					
				</table>
			
								

			</div>
		</div>
	</body>
</html>