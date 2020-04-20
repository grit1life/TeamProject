package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.DocBill;

@Mapper
public interface DocBillMapper {

	public List<DocBill> getDocBillList(int column);
	public int getDocBillListCnt();

	public List<DocBill> getDocBillSearchList(DocBill docBill);
	public int getDocBillSearchListCnt(DocBill docBill);
	
	public DocBill getDocBillForm(String billCode);
	
	public int getBillLastCode();
	public int getBillPayNumber(String contractCode);
	public int insertBill(DocBill docBill);
}
