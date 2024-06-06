package com.employee.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee.entity.EmployeeDto;
import com.employee.entity.OfficialDetails;
import com.employee.entity.PersonalDetails;
import com.employee.entity.User;
import com.employee.repository.OfficialRepositoy;
import com.employee.repository.PersonalRepository;
import com.employee.repository.UserRepository;

@Service
public class EmployeeService {

    @Autowired
    private PersonalRepository personalRepository;
    
    
    @Autowired
    OfficialRepositoy officialrepository;
    
    @Autowired
    UserRepository repo;
    
    
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    public List<EmployeeDto> getAllEmployees() {
    	
    	List<EmployeeDto> details= new ArrayList<EmployeeDto>();
        List<PersonalDetails> personalData=personalRepository.findAll();
        
        for(PersonalDetails data:personalData) {
        	EmployeeDto employeedto = new EmployeeDto();
        	employeedto.setEmployeeId(data.getOfficialDetails().getEmployeeId());
        	employeedto.setAddress(data.getAddress());
        	employeedto.setDateOfJoining(data.getOfficialDetails().getDateOfJoining());
        	employeedto.setDesignation(data.getOfficialDetails().getDesignation());
        	employeedto.setDob(data.getDob());
        	employeedto.setEmailAddress(data.getEmailAddress());
        	employeedto.setEmployeeName(data.getOfficialDetails().getEmployeeName());
        	employeedto.setEmployeeType(data.getOfficialDetails().getEmployeeType());
        	employeedto.setPhoneNo(data.getPhoneNo());
        	employeedto.setProjectName(data.getOfficialDetails().getProjectName());
        	details.add(employeedto);
        }
        return details;
        
        
    }

    public EmployeeDto getEmployeeById(String id) {
    	PersonalDetails data=  personalRepository.findByEmployeeId(id);
    	EmployeeDto employeedto = new EmployeeDto();
    	employeedto.setEmployeeId(data.getOfficialDetails().getEmployeeId());
    	employeedto.setAddress(data.getAddress());
    	employeedto.setDateOfJoining(data.getOfficialDetails().getDateOfJoining());
    	employeedto.setDesignation(data.getOfficialDetails().getDesignation());
    	employeedto.setDob(data.getDob());
    	employeedto.setEmailAddress(data.getEmailAddress());
    	employeedto.setEmployeeName(data.getOfficialDetails().getEmployeeName());
    	employeedto.setEmployeeType(data.getOfficialDetails().getEmployeeType());
    	employeedto.setPhoneNo(data.getPhoneNo());
    	employeedto.setProjectName(data.getOfficialDetails().getProjectName());
    	return employeedto;
    }

    public String createEmployee(PersonalDetails employee) {
    	
    	personalRepository.save(employee);
        return "Data saved Sucessfully";
        
        
    }
    
 
    
    public String updateEmployee(PersonalDetails employeeDetails) {      
        PersonalDetails existingPersonalDetails = personalRepository.findByEmployeeId(employeeDetails.getOfficialDetails().getEmployeeId());        
        if (existingPersonalDetails != null) {           
            OfficialDetails existingOfficialDetails = existingPersonalDetails.getOfficialDetails();
            existingOfficialDetails.setDateOfJoining(employeeDetails.getOfficialDetails().getDateOfJoining());
            existingOfficialDetails.setDesignation(employeeDetails.getOfficialDetails().getDesignation());
            existingOfficialDetails.setEmployeeName(employeeDetails.getOfficialDetails().getEmployeeName());
            existingOfficialDetails.setEmployeeType(employeeDetails.getOfficialDetails().getEmployeeType());
            existingOfficialDetails.setProjectName(employeeDetails.getOfficialDetails().getProjectName());
          
            existingPersonalDetails.setAddress(employeeDetails.getAddress());
            existingPersonalDetails.setDob(employeeDetails.getDob());
            existingPersonalDetails.setEmailAddress(employeeDetails.getEmailAddress());
            existingPersonalDetails.setName(employeeDetails.getName());
            existingPersonalDetails.setPhoneNo(employeeDetails.getPhoneNo());
            existingPersonalDetails.setSalary(employeeDetails.getSalary());

            personalRepository.save(existingPersonalDetails);

            return "Data Updated Successfully";
        } else {
            return "Employee not found";
        }
    }
        
        public PersonalDetails personalDetails(String employeeid) {
        	
        	PersonalDetails data = personalRepository.findByEmployeeId(employeeid);
        	if (data != null) { 
        	PersonalDetails personaldetails =new PersonalDetails();
        	personaldetails.setName(data.getOfficialDetails().getEmployeeName());
        	personaldetails.setAddress(data.getAddress());
        	personaldetails.setDob(data.getDob());
        	personaldetails.setEmailAddress(data.getEmailAddress());     
        	personaldetails.setPhoneNo(data.getPhoneNo());
        	personaldetails.setSalary(data.getSalary());
        	
        	return personaldetails;
        }else {
        	 throw new IllegalArgumentException("Please provide valid EmployeeId");
        }
        }
        
        
        public void deleteEmployee(String id) {
            PersonalDetails employee = personalRepository.findByEmployeeId(id);
            if (employee != null) {
                personalRepository.delete(employee);
            } else {
                throw new RuntimeException("Employee not found with id: " + id);
            }
        }
        
        
        
        public String register(@RequestBody User user) {
        	
        	String encryptedPwd = passwordEncoder.encode(user.getPassword());
        	user.setPassword(encryptedPwd);
        	
        	repo.save(user);
        	return "Data Saved Sucessfully";
        }
}
        
        
        
    

        
        
        
        
        
        
        
        
            

    
  

    
    

