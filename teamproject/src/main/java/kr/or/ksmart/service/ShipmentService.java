package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.domain.Shipment;
import kr.or.ksmart.mapper.ShipmentMapper;

@Service
public class ShipmentService {
	
	@Autowired
	private ShipmentMapper shipmentMapper;
	
	public List<Shipment> getShipmentList(){
		 List<Shipment> list = shipmentMapper.getShipmentList();
		 return list;
	}
	
	public List<Shipment> getShipmentList(boolean delivered){
		 List<Shipment> list = shipmentMapper.getShipmentList(delivered);
		 return list;
	}
	
	public List<Shipment> ajaxShipmentList(String shipmentCode){
		 List<Shipment> list = shipmentMapper.ajaxShipmentList(shipmentCode);
		 return list;
	}
}
