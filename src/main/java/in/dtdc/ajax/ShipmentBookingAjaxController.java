package in.dtdc.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.dtdc.bo.ShipmentStatusBO;
import in.dtdc.service.ShipmentBookingService;

@RestController
public class ShipmentBookingAjaxController {

	@Autowired
	private ShipmentBookingService service;
	
	@PostMapping("/api/get-shipment-details")
	public ResponseEntity<?> getShipmentBookingDetails(@RequestBody ShipmentBookingSearchCriteria criteria){
		
		System.out.println(criteria);
		
		String shipNumber = criteria.getShipmentNo();
		
		List<ShipmentStatusBO> body = service.getBookingDetailsByShipmentNumber(shipNumber);
		
		return ResponseEntity.ok(body);
	}
}
