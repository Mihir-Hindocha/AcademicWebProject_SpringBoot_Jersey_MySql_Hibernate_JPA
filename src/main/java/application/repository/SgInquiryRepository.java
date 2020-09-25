package application.repository;

import application.model.SgInquiry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SgInquiryRepository extends JpaRepository<SgInquiry, String> {

    List<SgInquiry> findAllByOrderByStatusAsc();

    List<SgInquiry> findAllByStatusOrderByTimeAsc(String status);

    SgInquiry findByStatus(String status);

    SgInquiry findByEmail(String email);

}
