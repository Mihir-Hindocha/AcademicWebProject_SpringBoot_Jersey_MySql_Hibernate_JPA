package application.response;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
public class SgInquiryDto {

    private String flatNo;
    private String status;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String question;
    private Date dob;
    private Timestamp time;
    private List<SgInquiryDto> sgInquiryDto;
}
