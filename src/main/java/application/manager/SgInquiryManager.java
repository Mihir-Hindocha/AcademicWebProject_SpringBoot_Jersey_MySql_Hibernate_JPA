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

    public List<SgInquiry> findAll() {
        return sgInquiryRepository.findAll();
    }

    public SgInquiry findByStatus(String status) {
        return sgInquiryRepository.findByStatus(status);
    }

    public SgInquiry findByEmail(String email) {
        return sgInquiryRepository.findByEmail(email);
    }

    public void delete(SgInquiry sgResponse) {
        sgInquiryRepository.delete(sgResponse);
    }

    public void save(SgInquiry sgResponse) {
        sgInquiryRepository.save(sgResponse);
    }
}
