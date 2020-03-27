package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Shipment;

@Mapper
public interface ShipmentMapper {

	public List<Shipment> getShipmentList(int firstClmn, int lastClmn);
	public int getShipmentListCnt();
	
	
	public List<Shipment> getDeliveredShipmentList(int firstClmn, int lastClmn);
	public int getDeliveredShipmentCnt();
	
	public List<Shipment> ajaxShipmentList(String shipmentCode);
	
}
