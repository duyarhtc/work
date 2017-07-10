package com.work.project.employee;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import com.work.project.employee.*;


@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	

}
