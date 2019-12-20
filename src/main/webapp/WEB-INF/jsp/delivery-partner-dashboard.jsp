<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DTDC - Delivery Partner</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../resource/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="../resource/css/cd_custom.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" media="all" href="../resource/css/daterangepicker.css" />
<link href="../resource/css/datatables.min.css" rel="stylesheet" type="text/css" />
<link href="../resource/fonts/css/all.css" rel="stylesheet">
<script type="text/javascript" src="../resource/js/jquery-ui.js"></script>
<script type="text/javascript" src="../resource/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../resource/js/moment.js"></script>
<script type="text/javascript" src="../resource/js/daterangepicker.js"></script>
<script type="text/javascript" src="../resource/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../resource/js/dataTables.bootstrap.min.js"></script>
<script defer src="../resource/fonts/js/all.js"></script>
</head>

<body>
	<!----------------- Header Starts -------------------->
	<div class="header">
		<div class="dtdclogo">
			WELCOME TO <br/> <span>DTDC - DELIVERY PARTNER</span>
		</div>
		<div class="FRPLUS"></div>
	</div>
	<!----------------- Header Ends -------------------->


	<!----------------- Search Criteria Starts --------------------action="/CP-Debit/cpdebitmisresult" -->
	<div class="panel-default container-fluid" >
		<div class="panel-body" id="resultbody">
			<form id="cpdebitForm">
				<div class="form-group col-lg-2">
					<label>Shipment Number</label> <input class="form-control"
						type="text" name="shipmentNo" id="shipmentNo" />
					
				</div>
				<div class="form-group col-lg-1" style="text-align: center;">
					<img src="../resource/images/or.png" alt="" />
				</div>
				<div class="form-group col-lg-2">
					<label>Select Booking  Period</label> <input class="form-control"
						type="text" name="daterange" onclick="forDateInput()"  id="daterange" placeholder="Enter Booking Period" />
				</div>
				<div class="form-group col-lg-1" style="text-align: center;">
					<img src="../resource/images/or.png" alt="" />
				</div>
				<div>
					<div  class="form-group col-lg-2">
						<label>Source</label>
							<select name="source" id="source" class="form-control">
									<option value="">select</option>
									<option value="Bangalore">Bangalore</option>
									<option value="Hyderabad">Hyderabad</option>
									<option value="Chennai">Chennai</option>
									<option value="Bhubaneswar">Bhubaneswar</option>
							</select>
					</div>
					<div class="form-group col-lg-2">
						<label>Destination</label>
							<select name="dest" id="dest"  class="form-control" >
								<option value="">select</option>
								<option value="Bangalore">Bangalore</option>
								<option value="Hyderabad">Hyderabad</option>
								<option value="Chennai">Chennai</option>
								<option value="Bhubaneswar">Bhubaneswar</option>
							</select>
					</div>
				</div>
				<div class="col-lg-2">
					<label>Process Status</label> <select title="Select status"
						class="form-control" name="status" id="status">
						<option>All</option>
						<option>pending</option>
						<option>delivered</option>
						<option>failure</option>
					</select>
				</div>
				<div class="form-group col-lg-2" style="margin-top: 20px;">
					<button type="submit"  id="submitButton" class="btn btn-success" >
						<span class="fa fa-check"></span>&nbsp;Submit
					</button>
				</div>
			</form>
		</div>
	</div>

	<!----------------- Search Criteria Ends -------------------->
	
	<!----------------- Search Result Table Starts -------------------->
	<div  class="panel-default container-fluid">
		<div id="table-div" class="panel-body">
			<table id="example" class="table table-striped table-bordered"></table>
		</div>
		<div id="message-div" class="panel-body"></div>
 	</div>

	<!----------------- Search Result Table Ends -------------------->
</body>
<a href="/logout.htm">Logout</a>	
<script type="text/javascript">
	$(function() {
			$('input[name="daterange"]').daterangepicker({
				autoUpdateInput : false,
				locale : {
					cancelLabel : 'Clear'
				}
			});
			$('input[name="daterange"]').on(
					'apply.daterangepicker',
					function(ev, picker) {
						$(this).val(
								picker.startDate.format('DD/MM/YY') + ' - '
										+ picker.endDate.format('DD/MM/YY'));
			});

			$('input[name="daterange"]').on('cancel.daterangepicker',
				function(ev, picker) {
					$(this).val('');
			});
	});


	jQuery(document).ready(function($){

		$("#shipmentNo").click(function(){

			$("#daterange").val("");
		    $("#source").val("");
		    $("#dest").val("");
		});

		$("#cpdebitForm").submit(function(event){

			event.preventDefault();

			var search={};

			search["shipmentNo"]=$("#shipmentNo").val();
			search["status"]=$("#status").val();


			getShipmentBookingDetails(search);
				
		});

		function getShipmentBookingDetails(searchCriteria){

			var data=JSON.stringify(searchCriteria);
			//alert(data);

			 $.ajax({
		         type: "POST",
		         contentType: "application/json",
		         url: "/api/get-shipment-details",
		         data: JSON.stringify(searchCriteria),
		         dataType: 'json',
		         cache: false,
		         timeout: 600000,
		         success: function (result) {

			         //alert("Success");
			         var stringResult=JSON.stringify(result);
			         //alert(stringResult);
			         displayTable(result);
		         },
		         error: function (e) {

		        	 alert("Failure");
		         }
		     });

		}

	});

	
	function displayTable(resultArr){


		if(resultArr.length==0){

			$("#message-div").html("No data found");
			$("#message-div").show();
			$("#table-div").hide();
		}


		$("#message-div").hide();
		var isSecondHit = document.getElementById("secondHit").value;
		if(secondHit != "Yes"){

			var tableHeaderRow = "<thead><tr><th>SL No</th><th>Shipment Number</th><th>Source</th><th>Destination</th><th>Date of booking</th><th>Status</th></tr></thead>";
			var tableDataRow="<tbody>";

				for(var i = 0; i < resultArr.length; i++){

					tableDataRow=tableDataRow+"<tr><td>"+(i+1)+"</td><td><a href='/show-specific-shipment-details.htm?shipmentId="+resultArr[i]["shipmentNo"]+"'>"+resultArr[i]["shipmentNo"]+"</td><td>"+resultArr[i]["source"]+"</td><td>"+resultArr[i]["destination"]+"</td><td>"+resultArr[i]["dateOfBooking"]+"</td><td>"+resultArr[i]["status"]+"</td></tr>"
				}

				tableDataRow=tableDataRow+"</tbody>";

				var finalTable = tableHeaderRow+tableDataRow;

				$("#example").html(finalTable);
				$("#example").DataTable().search( '' ).columns().search( '' ).draw();
				$("#table-div").show();
			    document.getElementById("secondHit").value="Yes";
				
		}else{

			var dataTable = $('#example').DataTable();
			dataTable.clear();

			for(var i = 0; i < resultArr.length; i++){

				dataTable.row.add([ (i+1) ,
					  "<a href='/show-specific-shipment-details.htm?shipmentId="+resultArr[i]["shipmentNo"]+"'>"+resultArr[i]["shipmentNo"]+"</a>",
					  resultArr[i]["source"],
					  resultArr[i]["destination"],
					  resultArr[i]["dateOfBooking"] , 
					  resultArr[i]["status"]
				]).search( '' ).columns().search( '' ).draw();
				$("#table-div").show();
			}

		}
		
	}

	window.onload = function() {

		 $('<input>').attr({
			    type: 'hidden',
			    id: 'secondHit',
			    name: 'bar',
			    value: 'No'
			}).appendTo('form');

		 $("#message-div").hide();
		 $("#table-div").hide();
	}			
</script>
</html>