package application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
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
}
