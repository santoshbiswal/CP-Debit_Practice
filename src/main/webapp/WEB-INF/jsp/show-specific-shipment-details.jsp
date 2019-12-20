<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Specific Shipment Details</title>
</head>
<body bgcolor="GreenYellow">
	<h1>Welcome To Specific Shipment Details</h1>
	<form>
		<div id="customer-details-div">
			<table border="1px" style="background-color: Fuchsia">
				<tr>
					<td>Consignment Number:</td>
					<td><input type="text" name="consignmentNo" value="${shipment.consgNo }" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" value="${shipment.name }" /></td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><input type="text" name="phone" value="${shipment.phone }" /></td>
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
								<td><input type="text" name="fromAddressLine" value="${shipment.fromAddress.addressLine }" /></td>
							</tr>
							<tr>
								<td>city:</td>
								<td><input type="text" name="fromCity" value="${shipment.fromAddress.city }" /></td>
							</tr>
							<tr>
								<td>state:</td>
								<td><input type="text" name="fromState" value="${shipment.fromAddress.state }" /></td>
							</tr>
						</table>
					</td>
					<td>
						<table border="1px" style="background-color: Turquoise">
							<tr>
								<td>address Line:</td>
								<td><input type="text" name="toAddressLine" value="${shipment.toAddress.addressLine }" /></td>
							</tr>
							<tr>
								<td>city:</td>
								<td><input type="text" name="toCity" value="${shipment.toAddress.city }" /></td>
							</tr>
							<tr>
								<td>state:</td>
								<td><input type="text" name="toState" value="${shipment.toAddress.state }" /></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div id="booking-details-div">
			<table>
				<tr>
					<td>Vas Prod Code:</td>
					<td>
						<input type="text" name="vasProdCode" value="${shipment.vasProdCode }" />
					</td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input type="text" name="price" value="${shipment.price }" /></td>
				</tr>
				<tr>
					<td>Booking Date Time :</td>
					<td><input type="text" name="bookingDtTime" value="${shipment.bookingDtTime }" /></td>
				</tr>
				<tr>
					<td>Quantity:</td>
					<td>
						<input type="text" name="quantity" value="${shipment.quantity }" />
					</td>
				</tr>
				<tr>
					<td>DELIVERY STATUS:</td>
					<td>
						<input type="text"  value="${shipment.status }" disabled="true"/>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Update" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
	</form>
	
	<a href="/dtdc-dashboard.htm">Back</a>
</body>
</html>						  