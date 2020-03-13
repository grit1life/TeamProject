package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Staff;

@Mapper
public interface StaffMapper {
	
	public Staff staffLogin(String staffId);
	
	public List<Staff> staffList();
}
