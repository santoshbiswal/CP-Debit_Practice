<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Shipment Booking</title>
</head>
<body bgcolor="GreenYellow">
	<h1>Welcome To Channel Partner Booking</h1>
	<form:form modelAttribute="booking">
		<div id="error-div">
			<span style="color: red"> <form:errors path="*" /></span>
		</div>
		<div id="customer-details-div">
			<table border="1px" style="background-color: Fuchsia">
				<tr>
					<td>Name:</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<td height="30px">
						<div align="center"
							style="width: 250px; height: 70%; background-color: Yellow; border-radius: 7px;">FROM</div>
					</td>
					<td height="30px">
						<div align="center"
							style="width: 250px; height: 70%; background-color: Yellow; border-radius: 7px;">TO</div>
					</td>
				</tr>
				<tr>
					<td>
						<table border="1px" style="background-color: Turquoise">
							<tr>
								<td>address Line:</td>
								<td><form:input path="fromAddressLine" /></td>
							</tr>
							<tr>
								<td>city:</td>
								<td><form:select path="fromCity" id="fromCity">
										<form:option value="">Select</form:option>
										<form:option value="Bangalore">Bangalore</form:option>
										<form:option value="Chennai">Chennai</form:option>
										<form:option value="Hyderabad">Hyderabad</form:option>
										<form:option value="Bhubaneswar">Bhubaneswar</form:option>
									</form:select></td>
							</tr>
							<tr>
								<td>state:</td>
								<td><form:input path="fromState" /></td>
							</tr>
						</table>
					</td>
					<td>
						<table border="1px" style="background-color: Turquoise">
							<tr>
								<td>address Line:</td>
								<td><form:input path="toAddressLine" /></td>
							</tr>
							<tr>
								<td>city:</td>
								<td><form:select path="toCity" id="toCity">
										<form:option value="">Select</form:option>
										<form:option value="Bangalore">Bangalore</form:option>
										<form:option value="Chennai">Chennai</form:option>
										<form:option value="Hyderabad">Hyderabad</form:option>
										<form:option value="Bhubaneswar">Bhubaneswar</form:option>
									</form:select></td>
							</tr>
							<tr>
								<td>state:</td>
								<td><form:input path="toState" /></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div id="booking-details-div">
			<table>
				<tr>
					<td>Vas-Prod-Code:</td>
					<td><form:select path="vasProdCode">
							<form:option value="">select</form:option>
							<form:option value="cod">cod</form:option>
							<form:option value="fod">fod</form:option>
							<form:option value="pob">pob</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>Source:</td>
					<td><form:input path="source" id="source"/></td>
				</tr>
				<tr>
					<td>Destination</td>
					<td><form:input path="destination" id="destination"/></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><form:input path="price"/></td>
				</tr>
				<tr>
					<td>Booking Dt Time :</td>
					<td><form:input path="bookingDtTime" type="date" /></td>
				</tr>
				<tr>
					<td>Quantity:</td>
					<td>
						<form:input path="quantity" />
						<form:hidden path="userId" value="${userId}"/>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Booking" /></td>
					<td><input type="reset" value="Reset"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
	</form:form>	
	<a href="/dtdc-logout.htm">Logout</a>
</body>
</html>