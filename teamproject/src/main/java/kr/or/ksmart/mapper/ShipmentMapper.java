package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Shipment;

@Mapper
public interface ShipmentMapper {

	public List<Shipment> getShipmentList();
	
	public List<Shipment> getShipmentList(boolean delivered);
	
	public List<Shipment> ajaxShipmentList(String shipmentCode);
	
}
