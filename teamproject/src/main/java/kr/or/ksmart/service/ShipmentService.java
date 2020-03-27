package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.domain.Deposit;
import kr.or.ksmart.domain.Pagination;
import kr.or.ksmart.domain.Shipment;
import kr.or.ksmart.mapper.ShipmentMapper;

@Service
public class ShipmentService {
	
	@Autowired
	private ShipmentMapper shipmentMapper;
	
	public Pagination<List<Shipment>> getShipmentList(int currentPage){
		int cnt = shipmentMapper.getShipmentListCnt();
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		List<Shipment> list = shipmentMapper.getShipmentList(firstClmn, lastClmn);
		int startPage = currentPage - 5;
		if(startPage<1) {
			startPage = 1;
		}
		int endPage = currentPage + 5;
		int lastPage = cnt/10 + 1;
		if(endPage > lastPage) {
			endPage = lastPage;
		}
		
		Pagination<List<Shipment>> p = new Pagination<List<Shipment>>();
		p.setList(list);
		p.setStartPage(startPage);
		p.setCurrentPage(currentPage);
		p.setEndPage(endPage);
		p.setLastPage(lastPage);
		return p;
	}
	
	public Pagination<List<Shipment>> getDeliveredShipmentList(int currentPage){
	    int cnt = shipmentMapper.getDeliveredShipmentCnt();
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		List<Shipment> list = shipmentMapper.getDeliveredShipmentList(firstClmn, lastClmn);
		int startPage = currentPage - 5;
		if(startPage<1) {
			startPage = 1;
		}
		int endPage = currentPage + 5;
		int lastPage = cnt/10 + 1;
		if(endPage > lastPage) {
			endPage = lastPage;
		}
		
		Pagination<List<Shipment>> p = new Pagination<List<Shipment>>();
		p.setList(list);
		p.setStartPage(startPage);
		p.setCurrentPage(currentPage);
		p.setEndPage(endPage);
		p.setLastPage(lastPage);
		return p;
		 
	}
	
	public List<Shipment> ajaxShipmentList(String shipmentCode){
		 List<Shipment> list = shipmentMapper.ajaxShipmentList(shipmentCode);
		 return list;
	}
}
