package com.employee.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.EmployeeDto;
import com.employee.entity.PersonalDetails;
import com.employee.entity.User;
import com.employee.service.EmployeeService;

@RestController
//@Controller
@RequestMapping("/employees")
public class EmployeeController {
	



    @Autowired
    private EmployeeService employeeService;
    
   
    
    @PostMapping()
    public PersonalDetails createEmployee(@RequestBody PersonalDetails employee) {
         employeeService.createEmployee(employee);
    	return employee;
    }
    
    @GetMapping("/{employeeId}")
    public EmployeeDto getEmployeeById(@PathVariable String employeeId) {           
        return employeeService.getEmployeeById(employeeId);
    }
    
    @GetMapping("/personal/{employeeid}")
    public PersonalDetails personalDetails(@PathVariable String employeeid) {
    	PersonalDetails data = employeeService.personalDetails(employeeid);
    	return data;
    }
    
    @PutMapping("/update")
    public String updateEmployee(@RequestBody PersonalDetails employee) {
    	String updatedEmployee = employeeService.updateEmployee(employee);
        return updatedEmployee;
    }
    
    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
       return "Employee deleted sucessfully";
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }  
  
    
    @PostMapping("/saveuser")
    public String saveUser(@RequestBody User user) {
    String data = employeeService.register(user);
    
    	return data;

    }
    
 
    


  
}