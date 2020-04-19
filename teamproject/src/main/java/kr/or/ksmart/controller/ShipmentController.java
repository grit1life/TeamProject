package kr.or.ksmart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ksmart.domain.Pagination;
import kr.or.ksmart.domain.Shipment;
import kr.or.ksmart.service.ShipmentService;

@Controller
public class ShipmentController {
	
	@Autowired
	private ShipmentService shipmentService;
	
	@GetMapping("/staff/rentalShipList")
	public String rentalShipList(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page
								,@RequestParam(value = "deliveredPage", required = false, defaultValue = "1") int deliveredPage) {
		
		Pagination<List<Shipment>> p = shipmentService.getShipmentList(page);
		model.addAttribute("list", p.getList());
		model.addAttribute("startPage", p.getStartPage());
		model.addAttribute("currentPage", p.getCurrentPage());
		model.addAttribute("endPage", p.getEndPage());
		model.addAttribute("lastPage", p.getLastPage());
		
		Pagination<List<Shipment>> deliveredP = shipmentService.getDeliveredShipmentList(deliveredPage);
		model.addAttribute("deliveredList", deliveredP.getList());
		model.addAttribute("deliveredStartPage", deliveredP.getStartPage());
		model.addAttribute("deliveredCurrentPage", deliveredP.getCurrentPage());
		model.addAttribute("deliveredEndPage", deliveredP.getEndPage());
		model.addAttribute("deliveredLastPage", deliveredP.getLastPage());
		
		return "shipment/rentalShipList";
	}

	@GetMapping("/staff/rentalShipSearchList")
	public String rentalShipSearchList(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page
								,@RequestParam(value = "deliveredPage", required = false, defaultValue = "1") int deliveredPage
								, Shipment shipment) {
		
		Pagination<List<Shipment>> p = shipmentService.getShipmentSearchList(page, shipment);
		model.addAttribute("list", p.getList());
		model.addAttribute("startPage", p.getStartPage());
		model.addAttribute("currentPage", p.getCurrentPage());
		model.addAttribute("endPage", p.getEndPage());
		model.addAttribute("lastPage", p.getLastPage());
		
		Pagination<List<Shipment>> deliveredP = shipmentService.getDeliveredShipmentSearchList(deliveredPage, shipment);
		model.addAttribute("deliveredList", deliveredP.getList());
		model.addAttribute("deliveredStartPage", deliveredP.getStartPage());
		model.addAttribute("deliveredCurrentPage", deliveredP.getCurrentPage());
		model.addAttribute("deliveredEndPage", deliveredP.getEndPage());
		model.addAttribute("deliveredLastPage", deliveredP.getLastPage());
		
		model.addAttribute("shipment", shipment);
		
		return "shipment/rentalShipSearchList";
	}

	@PostMapping("/staff/deliveredShipmentUpdate")
	public @ResponseBody Map<String, Object> deliveredShipmentUpdate(@RequestBody Map<String, Object> map) {
		String shipmentCode = (String) map.get("shipmentCode");
		int result = shipmentService.deliveredShipmentUpdate(shipmentCode);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		return resultMap;
	}
	@PostMapping("/ajaxShipmentList")
	public @ResponseBody List<Shipment> ajaxShipmentList(@RequestBody Map<String, Object> map) {

		String shipmentCode = (String) map.get("shipmentCode");
		List<Shipment> list = shipmentService.ajaxShipmentList(shipmentCode);
		return list;
	}
}
