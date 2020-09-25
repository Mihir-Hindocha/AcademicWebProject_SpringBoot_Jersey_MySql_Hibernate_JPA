package application.service;

import application.helper.SgInquiryHelper;
import application.manager.SgInquiryManager;
import application.model.SgInquiry;
import application.response.SgInquiryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Service
public class SgInquiryService {

    private @Autowired
    SgInquiryHelper sgResponseHelper;

    private @Autowired
    SgInquiryManager sgResponseManager;

    public List<SgInquiryDto> getTotalInquiries() {
        List<SgInquiry> sgTotalInquiries = sgResponseManager.findAllInquiriesOrderByStatusAsc();
        return sgTotalInquiries.stream().map(sgResponse -> sgResponseHelper.buildInquiryCollection(sgResponse))
                .collect(Collectors.toList());
    }


    public List<SgInquiryDto> getInquiriesByStatus(String status) {
        List<SgInquiry> sgInquiriesList = sgResponseManager.findAllInquiriesByStatusOrderByTimeAsc(status);
        return sgInquiriesList.stream().map(sgResponse -> sgResponseHelper.buildInquiryCollection(sgResponse))
                .collect(Collectors.toList());
    }

    public boolean changeInquiryStatus(String status, String email) {
        SgInquiry currentInquiry = sgResponseManager.findByEmail(email);
        if (currentInquiry == null) {
            return false;
        }
        currentInquiry.setStatus(status);
        SgInquiry savedInquiry = sgResponseManager.save(currentInquiry);
        return savedInquiry != null;
    }

    public boolean deleteInquiry(String email) {
        SgInquiry currentInquiry = sgResponseManager.findByEmail(email);
        if (currentInquiry == null) {
            return false;
        } else {
            sgResponseManager.delete(currentInquiry);
            return true;
        }
    }
}
