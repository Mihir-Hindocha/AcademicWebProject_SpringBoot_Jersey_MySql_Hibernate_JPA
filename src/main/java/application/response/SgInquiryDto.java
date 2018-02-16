package application.response;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


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
	
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public List<SgInquiryDto> getSgInquiryDto() {
		return sgInquiryDto;
	}
	public void setSgInquiryDto(List<SgInquiryDto> sgInquiryDto) {
		this.sgInquiryDto = sgInquiryDto;
	}
	
	
}
