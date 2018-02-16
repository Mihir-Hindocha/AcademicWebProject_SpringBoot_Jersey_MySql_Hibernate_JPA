package application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import application.helper.SgInquiryHelper;
import application.manager.SgInquiryManager;
import application.model.SgInquiry;
import application.response.SgInquiryDto;

@Component
@Service
public class SgInquiryService {

	private @Autowired SgInquiryHelper sgResponseHelper;
	private @Autowired SgInquiryManager sgResponseManager;
	
	public SgInquiryDto getTotalInquiries() {
		List<SgInquiry> sgTotalInquiries = sgResponseManager.findAll();
		SgInquiryDto sgTotalInquiriesDto = new SgInquiryDto();
		sgTotalInquiriesDto.setSgInquiryDto(
				sgTotalInquiries.stream().map(sGResponse->sgResponseHelper.buildInquiryCollection(sGResponse)).collect(Collectors.toList()));		
		
		return sgTotalInquiriesDto;
	}

}
