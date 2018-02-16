package application.helper;


import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import application.model.SgInquiry;
import application.response.SgInquiryDto;

@Component
public class SgInquiryHelper {
	
	@Autowired
	ServletContext context;
	
	public SgInquiryDto buildInquiryCollection(SgInquiry sgInquiry) {
		SgInquiryDto sgInquiryDto = new SgInquiryDto();
		
		sgInquiryDto.setFlatNo(sgInquiry.getFlatNo());
		sgInquiryDto.setStatus(sgInquiry.getStatus());
		sgInquiryDto.setName(sgInquiry.getName());
		sgInquiryDto.setPhone(sgInquiry.getPhone());
		sgInquiryDto.setEmail(sgInquiry.getEmail());
		sgInquiryDto.setAddress(sgInquiry.getAddress());
		sgInquiryDto.setQuestion(sgInquiry.getQuestion());
		sgInquiryDto.setDob(sgInquiry.getDob());
		sgInquiryDto.setTime(sgInquiry.getTime());
	
		return sgInquiryDto;
	}

}
