package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ksmart.domain.Shipment;
import kr.or.ksmart.service.ShipmentService;

@Controller
public class ShipmentController {
	
	@Autowired
	private ShipmentService shipmentService;
	
	@GetMapping("/staff/rentalShipList")
	public String rentalShipList(Model model) {

		List<Shipment> list = shipmentService.getShipmentList();
		boolean delivered = true;
		List<Shipment> deliveredList = shipmentService.getShipmentList(delivered);
		model.addAttribute("list", list);
		model.addAttribute("deliveredList", deliveredList);
		
		return "shipment/rentalShipList";
	}
	
	@PostMapping("/ajaxShipmentList")
	public @ResponseBody List<Shipment> ajaxShipmentList(@RequestBody Map<String, Object> map) {

		String shipmentCode = (String) map.get("shipmentCode");
		List<Shipment> list = shipmentService.ajaxShipmentList(shipmentCode);
		return list;
	}
}
