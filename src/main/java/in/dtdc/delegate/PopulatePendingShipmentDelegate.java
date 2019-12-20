package in.dtdc.delegate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.dtdc.model.ShipmentBooking;
import in.dtdc.model.ShipmentDelivery;
import in.dtdc.service.ShipmentBookingService;
import in.dtdc.service.ShipmentDeliveryService;

@Component
public class PopulatePendingShipmentDelegate {

	@Autowired
	private ShipmentBookingService bookingService;
	
	@Autowired
	private ShipmentDeliveryService deliveryService;
	
	
	public void doPopulateIntoDelivery(Date now,Date tomorrow){
		
		List<ShipmentBooking> shipmentBookings = bookingService.getBookingDetailsByDate(now, tomorrow);
		
		populateInToDelivery(shipmentBookings);
		System.out.println(shipmentBookings);
	}
	
	public void populateInToDelivery(List<ShipmentBooking> array) {
		
		for(ShipmentBooking booking : array) {
			
			ShipmentDelivery delivery = new ShipmentDelivery();
			delivery.setDeliveryConsgNo(booking.getConsg_no());
			delivery.setStatus("pending");
			
			ShipmentDelivery shipmentDelivery = deliveryService.saveDelivery(delivery);
			System.out.println("Delivery ID : "+shipmentDelivery.getDeliveryId());
		}
	}
	
}
