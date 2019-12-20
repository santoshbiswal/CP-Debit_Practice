package in.dtdc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.dtdc.bo.SpecificShipmentDetailsBO;
import in.dtdc.service.SpecificShipmentDetailsService;

@Controller
public class SpecificShipmentDetailsController {

	@Autowired
	private SpecificShipmentDetailsService service;
	
	@GetMapping("/show-specific-shipment-details.htm")
	public ModelAndView getSpecificShipmentDetails(@RequestParam("shipmentId") String consignmentnumber) {
		
		ModelAndView mav = new ModelAndView();
		
		SpecificShipmentDetailsBO result = service.getSpecificShipmentDetails(consignmentnumber);
		
		mav.addObject("shipment", result);
		mav.setViewName("show-specific-shipment-details");
		
		return mav;
	}
}
