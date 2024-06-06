package com.employee.entity;


import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity
public class PersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private LocalDate dob;
    private String address;
    private String phoneNo;
    private String emailAddress;
    private double salary;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")  
    private OfficialDetails OfficialDetails;


	public PersonalDetails() {
		
	}


	public PersonalDetails(String name, LocalDate dob, String address, String phoneNo, String emailAddress,
			double salary, OfficialDetails officialDetails ) {
		super();
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.phoneNo = phoneNo;
		this.emailAddress = emailAddress;
		this.salary = salary;
		this.OfficialDetails = officialDetails;
	}
   
   
   
}
