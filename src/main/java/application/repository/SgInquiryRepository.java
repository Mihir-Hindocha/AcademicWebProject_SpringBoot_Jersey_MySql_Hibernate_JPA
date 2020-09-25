package application.repository;

import application.model.SgInquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SgInquiryRepository extends JpaRepository<SgInquiry, String> {

    SgInquiry findByStatus(String status);

    SgInquiry findByEmail(String email);

}
