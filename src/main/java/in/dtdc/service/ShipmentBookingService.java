package in.dtdc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dtdc.bo.ShipmentStatusBO;
import in.dtdc.model.ShipmentBooking;
import in.dtdc.repo.ShipmentBookingRepository;

@Service
public class ShipmentBookingService {

	@Autowired
	private ShipmentBookingRepository repository;
	
	public ShipmentBooking saveShipmentBooking(ShipmentBooking booking) {
		
		return repository.save(booking);
	}
	
	public List<ShipmentBooking> getBookingDetailsByDate(Date now,Date tomorrow) {
		
		return repository.getBookingDetails(now, tomorrow);
		
	}
	
	public List<ShipmentStatusBO> getBookingDetailsByShipmentNumber(String consignmentnumber) {
		
		List<Object[]> resultData = repository.getShipmentBookingDetailsByConsgNo(consignmentnumber);
		
		List<ShipmentStatusBO> shipmentStatusBOs = convertObjectArrayToShipmentStatusBo(resultData);
		
		return shipmentStatusBOs;
	}
	
	private List<ShipmentStatusBO> convertObjectArrayToShipmentStatusBo(List<Object[]> shimentObjects) {
		
		List<ShipmentStatusBO> shipObjectList = new ArrayList<ShipmentStatusBO>();
		
			//s.CONSG_NO,s.SOURCE,s.DESTINATION,s.BOOKING_DATE_TIME,d.STATUS 
			for(Object[] arr : shimentObjects) {
				
				ShipmentStatusBO bo = new ShipmentStatusBO();
				
				bo.setShipmentNo(String.valueOf(arr[0]));
				bo.setSource(String.valueOf(arr[1]));
				bo.setDestination(String.valueOf(arr[2]));
				
				Date date = converObjectToDate(arr[3]);
				bo.setDateOfBooking(date);
				bo.setStatus(String.valueOf(arr[4]));
				
				shipObjectList.add(bo);
				
			}
			
			return shipObjectList;
			
	}
	
	private Date converObjectToDate(Object date){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date convertedDate=null;
		
		try {
			convertedDate = sdf.parse(String.valueOf(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return convertedDate;
	}

}
