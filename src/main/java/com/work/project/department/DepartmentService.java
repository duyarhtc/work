package com.work.project.department;
/* service and CRUD function*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.project.employee.Employee;




@Service
public class DepartmentService {

	
	@Autowired
	private DepartmentRepository departmentrepository;
	
	
	public Iterable<Department> getAllDepartments(){
		return departmentrepository.findAll();
	}
	
	public Department getDepartment(Integer id){
		return departmentrepository.findOne(id);
		
	}

	
	public Department addDepartment(Department department) {
	   return departmentrepository.save(department);
	}



	public Boolean deleteDepartment(Integer id) {
		
		
		departmentrepository.delete(id);
		return true;
		
		
	}

}
