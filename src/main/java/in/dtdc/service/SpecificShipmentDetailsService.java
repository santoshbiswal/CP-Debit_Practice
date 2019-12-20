package in.dtdc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dtdc.bo.SpecificAddressDetailsBO;
import in.dtdc.bo.SpecificShipmentDetailsBO;
import in.dtdc.repo.SpecificShipmentDetailsRepository;

@Service
public class SpecificShipmentDetailsService {

	@Autowired
	private SpecificShipmentDetailsRepository repository;
	
	public SpecificShipmentDetailsBO getSpecificShipmentDetails(String consignmentnumber) {
		
		List<Object[]> shipmentObjectList = repository.getSpecificShipmentDetails(consignmentnumber);
		
		return prepareSpecificShipmentFromObjectArrayList(shipmentObjectList);
	}
	
	private SpecificShipmentDetailsBO prepareSpecificShipmentFromObjectArrayList(List<Object[]> objList) {
		
		SpecificShipmentDetailsBO resultData = new SpecificShipmentDetailsBO();
		
			for(int i=0;i<objList.size();i++) {
				
				Object[] arr = objList.get(i);
				
				if(i==0) {
					
					resultData.setName(String.valueOf(arr[0]));
					resultData.setPhone(String.valueOf(arr[1]));
					resultData.setConsgNo(String.valueOf(arr[2]));
					resultData.setVasProdCode(String.valueOf(arr[3]));
					resultData.setSource(String.valueOf(arr[4]));
					resultData.setDestination(String.valueOf(arr[5]));
					
					Date date = converObjectToDate(arr[6]);
					resultData.setBookingDtTime(date);
					
					String price = String.valueOf(arr[7]);
					resultData.setPrice(Integer.valueOf(price));
					
					String quantity = String.valueOf(arr[8]);
					resultData.setQuantity(Integer.valueOf(quantity));
					
					resultData.setStatus(String.valueOf(arr[9]));
				}
				
				SpecificAddressDetailsBO addBo = new SpecificAddressDetailsBO();
				addBo.setAddressLine(String.valueOf(arr[10]));
				addBo.setCity(String.valueOf(arr[11]));
				addBo.setState(String.valueOf(arr[12]));
				
				String addressType = String.valueOf(arr[13]);
				
				if(addressType.equals("FROM")) {
					
					resultData.setFromAddress(addBo);
				}else {
					
					resultData.setToAddress(addBo);
				}
			}
			
			return resultData;
	}
	
	private Date converObjectToDate(Object date){
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 
		 Date convertedDate=null;
		 try { 
			 convertedDate = sdf.parse(String.valueOf(date)); 
			 
	     } catch (ParseException e) { 
	           e.printStackTrace(); 
	     }
		 return convertedDate; 
	}
}
