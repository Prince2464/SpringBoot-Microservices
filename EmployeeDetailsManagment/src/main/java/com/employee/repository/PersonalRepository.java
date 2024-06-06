package com.employee.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.entity.PersonalDetails;

public interface PersonalRepository extends JpaRepository<PersonalDetails, Long> {

	  @Query("SELECT p FROM PersonalDetails p WHERE p.OfficialDetails.employeeId = :employeeId")
	    PersonalDetails findByEmployeeId(@Param("employeeId") String employeeId);
	
	
}
