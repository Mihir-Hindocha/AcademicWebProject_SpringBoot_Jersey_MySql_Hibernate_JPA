package application.service;

import application.helper.SgInquiryHelper;
import application.manager.SgInquiryManager;
import application.model.SgInquiry;
import application.response.SgInquiryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class SgInquiryService {

    private @Autowired
    SgInquiryHelper sgResponseHelper;

    private @Autowired
    SgInquiryManager sgResponseManager;

    public SgInquiryDto getTotalInquiries() {
        List<SgInquiry> sgTotalInquiries = sgResponseManager.findAll();
        SgInquiryDto sgTotalInquiriesDto = new SgInquiryDto();
        sgTotalInquiriesDto.setSgInquiryDto(
                sgTotalInquiries.stream().map(sGResponse -> sgResponseHelper.buildInquiryCollection(sGResponse)).toList());

        return sgTotalInquiriesDto;
    }
}
