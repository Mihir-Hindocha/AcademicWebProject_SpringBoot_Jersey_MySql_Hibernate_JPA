package application.manager;

import application.model.SgInquiry;
import application.repository.SgInquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class SgInquiryManager {
    private @Autowired
    SgInquiryRepository sgInquiryRepository;

    public List<SgInquiry> findAllInquiriesOrderByStatusAsc() {
        return sgInquiryRepository.findAllByOrderByStatusAsc();
    }

    public List<SgInquiry> findAllInquiriesByStatusOrderByTimeAsc(String status) {
        return sgInquiryRepository.findAllByStatusOrderByTimeAsc(status);
    }

    public SgInquiry findByEmail(String email) {
        return sgInquiryRepository.findByEmail(email);
    }

    public void delete(SgInquiry sgResponse) {
        sgInquiryRepository.delete(sgResponse);
    }

    public SgInquiry save(SgInquiry sgResponse) {
        return sgInquiryRepository.save(sgResponse);
    }

}
