package kr.or.ksmart.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Shipment;

@Mapper
public interface ShipmentMapper {

	public List<Shipment> getShipmentList(int firstClmn, int lastClmn);
	public int getShipmentListCnt();
	
	public List<Shipment> getDeliveredShipmentList(int firstClmn, int lastClmn);
	public int getDeliveredShipmentCnt();
	
	public List<Shipment> getShipmentSearchList(Shipment shipment);
	public int getShipmentSearchListCnt(Shipment shipment);
	
	public List<Shipment> getDeliveredShipmentSearchList(Shipment shipment);
	public int getDeliveredShipmentSearchCnt(Shipment shipment);
	
	public List<Shipment> ajaxShipmentList(String shipmentCode);
	
	public int getShipmentLastCode();
	public int insertShipmentList(Map<String, Object> map); 	
	
	public int deliveredShipmentUpdate(String shipmentCode);
}