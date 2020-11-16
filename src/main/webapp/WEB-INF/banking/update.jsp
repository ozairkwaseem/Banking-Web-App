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
	<title>Deposit or Withdraw</title>
</head>
	<body>
	
		<div class="container">
		
			<h2>Hello, ${ user.firstName }</h2>
		<h1>Below You Can Deposit or Withdraw</h1>
			<hr/>
			<div class="new-idea float float-left">
			
				<form:form action="/home/update" method="get" modelAttribute="bankaccounts">
					<form:hidden value="${ user.id }" path="bankuser"/>
						<div class="form-group">
						<form:label path="checkingBalance">How much do you want to Withdraw from checking?</form:label>
						<form:errors path="checkingBalance"/>
						<form:input class="form-control" path="checkingBalance"></form:input>
					</div>
					
					
  				 <button>Withdraw from Checking</button>				    
			</form:form>
			
				<form:form action="/home/update" method="get" modelAttribute="bankaccounts">
					<form:hidden value="${ user.id }" path="bankuser"/>
						<div class="form-group">
						<form:label path="savingsBalance">How much do you want to Withdraw from savings?</form:label>
						<form:errors path="savingsBalance"/>
						<form:input class="form-control" path="savingsBalance"></form:input>
					</div>
					
					
  				 <button>Withdraw from Savings</button>				    
			</form:form>
						<form:form action="/home/${bankaccounts.id}/depositchecking" method="get" modelAttribute="bankaccounts">
					<form:hidden value="${ user.id }" path="bankuser"/>
						<div class="form-group">
						<form:label path="checkingBalance">How much do you want to deposit into checking?</form:label>
						<form:errors path="checkingBalance"/>
						<form:input class="form-control" path="checkingBalance"></form:input>
					</div>
					
					
  				 <button>Deposit into Checking</button>				    
			</form:form>
			
				<form:form action="/home/update" method="get" modelAttribute="bankaccounts">
					<form:hidden value="${ user.id }" path="bankuser"/>
						<div class="form-group">
						<form:label path="savingsBalance">How much do you want to deposit into savings?</form:label>
						<form:errors path="savingsBalance"/>
						<form:input class="form-control" path="savingsBalance"></form:input>
					</div>
					
					
  				 <button>Deposit into Savings</button>				    
			</form:form>
			</div>
		
						
					
				</table>
			
								

			</div>
		</div>
	</body>
</html>