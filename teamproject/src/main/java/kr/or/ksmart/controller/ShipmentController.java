package kr.or.ksmart.controller;

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
	public String rentalShipList(Model model, @RequestParam(value = "page", required = false) String page
								,@RequestParam(value = "deliveredPage", required = false) String deliveredPage) {
		if(page==null) {
			page = "1";
		}
		int pageNum = Integer.parseInt(page);
		Pagination<List<Shipment>> p = shipmentService.getShipmentList(pageNum);
		model.addAttribute("list", p.getList());
		model.addAttribute("startPage", p.getStartPage());
		model.addAttribute("currentPage", p.getCurrentPage());
		model.addAttribute("endPage", p.getEndPage());
		model.addAttribute("lastPage", p.getLastPage());
		
		if(deliveredPage==null) {
			deliveredPage = "1";
		}
		int deliveredPageNum = Integer.parseInt(deliveredPage);
		Pagination<List<Shipment>> deliveredP = shipmentService.getDeliveredShipmentList(deliveredPageNum);
		model.addAttribute("deliveredList", deliveredP.getList());
		model.addAttribute("deliveredStartPage", deliveredP.getStartPage());
		model.addAttribute("deliveredCurrentPage", deliveredP.getCurrentPage());
		model.addAttribute("deliveredEndPage", deliveredP.getEndPage());
		model.addAttribute("deliveredLastPage", deliveredP.getLastPage());
		
		return "shipment/rentalShipList";
	}
	
	@PostMapping("/ajaxShipmentList")
	public @ResponseBody List<Shipment> ajaxShipmentList(@RequestBody Map<String, Object> map) {

		String shipmentCode = (String) map.get("shipmentCode");
		List<Shipment> list = shipmentService.ajaxShipmentList(shipmentCode);
		return list;
	}
}
