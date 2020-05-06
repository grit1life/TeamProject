package kr.or.ksmart.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.CompanyModal;
import kr.or.ksmart.domain.CustomerModal;
import kr.or.ksmart.domain.DocContractInsert;
import kr.or.ksmart.mapper.DocContractMapper;

@Service
@Transactional
public class DocContractService {
	
	@Autowired
	private DocContractMapper docContractMapper;
	
	public List<CustomerModal> customerModalList(CustomerModal customerModal) {
		return docContractMapper.customerModalList(customerModal);
	}
	public List<CustomerModal> customerModalList() {
		return docContractMapper.customerModalList();
	}
	
	public List<CompanyModal> companyModalList(CompanyModal companyModal) {
		return docContractMapper.companyModalList(companyModal);
	}
	public List<CompanyModal> companyModalList() {
		return docContractMapper.companyModalList();
	}
	//insert 처리
	public int contractInsertAjax(DocContractInsert docContractInsert,HttpSession session) {
		String staffId = (String)session.getAttribute("staffId");
		docContractInsert.setInputStaffCode(staffId);
		
		//건적서 E,계약서 C + 작성날짜 + No
		Date date=new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		String formattedDate=dateFormat.format(date);
		String codeDate = "C_"+formattedDate+"_";
		String codeDateNoS = docContractMapper.maxCode(codeDate);
		System.out.println("-----------------codeDateNoS------------------");
		System.out.println(codeDateNoS);
		if(codeDateNoS==null)codeDateNoS="0";
		int codeDateNo = Integer.parseInt(codeDateNoS);
		codeDateNo += 1 ;
		System.out.println(codeDateNo);
		docContractInsert.setContractCode(codeDate+codeDateNo);
		
		return docContractMapper.contractInsertAjax(docContractInsert);
	}

	
	
}
