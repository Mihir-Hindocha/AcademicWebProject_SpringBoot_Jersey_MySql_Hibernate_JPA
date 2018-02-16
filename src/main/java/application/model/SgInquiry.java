package application.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sg_inquiry")
public class SgInquiry {

	@Column(name = "flatno")
	private String flatNo;

	@Column(name = "status")
	private String status;

	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;
	@Id
	@Column(name = "email")
	private String email;

	// Date of Booking
	@Column(name = "dob")
	private Date dob;

	@Column(name = "address")
	private String address;

	@Column(name = "question")
	private String question;

	// Timestamp of Inquiry
	@Column(name = "time")
	private Timestamp time;

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

}
