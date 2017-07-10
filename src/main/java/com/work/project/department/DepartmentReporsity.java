package com.work.project.department;



import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface DepartmentReporsity extends CrudRepository< Department, Integer> {
	
	public List<Department> findByEmployeeId(int empid);

}
