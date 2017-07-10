package com.work.project.employee;
/*service and CRUD function*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;






@Service
public class EmployeeService {

	
	@Autowired
	private EmployeeRepository employeerepository;
	
	
	public Iterable<Employee> getAllEmployees(){
		return employeerepository.findAll();
	}

		
		
	
	public Employee getEmployee(int id){//update işleminde de kullanıyoruz.
		return employeerepository.findOne(id);
		
	}

	
	public Employee addEmployee(Employee employee) {//update işleminde de kullanıyoruz.
	    return employeerepository.save(employee);
	}


	public boolean deleteEmployee(int id) {
		
		employeerepository.delete(id);
		return true;
		
		
	}
	

}
