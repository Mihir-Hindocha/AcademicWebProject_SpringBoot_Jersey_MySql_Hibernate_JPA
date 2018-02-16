package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.SgInquiry;

public interface SgInquiryRepository extends JpaRepository<SgInquiry, String> {

	SgInquiry findByStatus(String status);

	SgInquiry findByEmail(String email);

}
