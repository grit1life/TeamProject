package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ksmart.domain.PriceGoods;
import kr.or.ksmart.domain.PriceSale;
import kr.or.ksmart.service.GoodsCategoryService;
import kr.or.ksmart.service.PriceService;

@Controller
public class PriceController {

	@Autowired
	private PriceService priceService;
	
	@Autowired
	private GoodsCategoryService goodsCategoryService;
	
	@PostMapping(value="/saleApplication", produces = "application/json")
	@ResponseBody
	public double saleApplication(@RequestParam(value="period")String period) {
		double rate = priceService.saleApplication(period);
		System.out.println("saleApplication");
		return rate;
	}
	//상품 단가 리스트, 단가입력 패이지(검색 전 후)
	@GetMapping("/staff/goodsPriceList")
	public String goodsPriceList(PriceGoods priceGoods,Model model) {
		System.out.println(priceGoods.toString());
		List<PriceSale> goodsPriceList = priceService.goodsPriceList(priceGoods);
		model.addAttribute("goodsPriceList", goodsPriceList);
		
		model.addAttribute("getGoodsCategoryList", goodsCategoryService.getGoodsCategoryList());
		return "price/goodsPriceList";
	}
	//단가 등록
	@PostMapping("/admin/goodsPriceInsert")
	public String goodsPriceInsert(PriceGoods priceGoods, HttpSession session, Model model) {
		System.out.println("---------------goodsPriceInsert controller-------------");
		System.out.println(priceGoods.getGoodsCode()+"<-goodsCode");
		System.out.println(priceGoods.getRentalDayPrice()+"<-rentalDayPrice");
		
		priceService.goodsPriceInsert(priceGoods, session);
		return "redirect:/staff/goodsPriceList";
	}

	//장기 렌탈 화면 표시(리스트도 표시)
	@GetMapping("/admin/basicSaleInsert")
	public String basicSaleInsert(Model model) {
		List<String> discountStartDayList = priceService.discountStartDay();
		model.addAttribute("discountStartDayList", discountStartDayList);
		return "price/basicSaleInsert";
	}
	//ajax로 할인 적용 날짜를 받고, 상세 표시
	@GetMapping("/staff/disDetailsList")
	public String disDetailsList(@RequestParam(value="disStart")String disStart,Model model) {
		List<PriceSale> disDetailsList = priceService.disDetailsList(disStart);
		model.addAttribute("disDetailsList", disDetailsList);
		model.addAttribute("getDiscountStartDay", disDetailsList.get(0).getDiscountStartDay());
		model.addAttribute("getInputStaffName", disDetailsList.get(0).getInputStaffName());
		model.addAttribute("getInputDate", disDetailsList.get(0).getInputDate());
		return "price/discountDetails";
	}
	
	//ajax로 할인을 세로 Insert
	@PostMapping("/admin/disInsert")
	public String disInsert(@RequestBody Map<String,Object> param
							,Model model,HttpSession session) {
		System.out.println(param.toString());
		System.out.println(param.get("periodList").toString());
		System.out.println(param.get("rateList").toString());
		System.out.println(param.get("discountStartDay").toString());
		priceService.discountInsert(param,session);
		return "price/discountDetails";
	}
	//할인을 삭제
	@GetMapping("/admin/discountDelete")
	public String discountDelete(@RequestParam(value="discountStartDay")String discountStartDay) {
		priceService.discountDelete(discountStartDay);
		return "redirect:/admin/basicSaleInsert";
	}

}
