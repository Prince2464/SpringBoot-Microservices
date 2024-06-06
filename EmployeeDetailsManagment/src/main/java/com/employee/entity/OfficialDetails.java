package com.employee.entity;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity
public class OfficialDetails {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String employeeId;
    private String employeeName;
    private LocalDate dateOfJoining;
    private String designation;
    private String projectName;
    private String employeeType;
	public OfficialDetails() {
		
	}
	public OfficialDetails(String employeeId ,String employeeName, LocalDate dateOfJoining, String designation, String projectName,
			String employeeType) {
		super();
		this.employeeId=employeeId;
		this.employeeName = employeeName;
		this.dateOfJoining = dateOfJoining;
		this.designation = designation;
		this.projectName = projectName;
		this.employeeType = employeeType;
	}
    
	
	
   
    

  

   


	

  
}