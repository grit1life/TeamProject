package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.DocBill;

@Mapper
public interface DocBillMapper {

	public List<DocBill> getDocBillList();
	
	public DocBill getDocBillForm(String billCode);
	
}
