package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.CompanyModal;
import kr.or.ksmart.domain.CustomerModal;
import kr.or.ksmart.domain.DocContractForm;
import kr.or.ksmart.domain.DocContractInsert;

@Mapper
public interface DocContractMapper {

	public List<CustomerModal> customerModalList(CustomerModal customerModal);
	public List<CustomerModal> customerModalList();
	
	public List<CompanyModal> companyModalList(CompanyModal companyModal);
	public List<CompanyModal> companyModalList();
	
	public int contractInsertAjax(DocContractInsert docContractInsert);
	
	public String maxCode(String codeDate);
}
