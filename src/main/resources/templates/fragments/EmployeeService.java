package com.work.project.employee;


import com.work.project.employee.Employee;

public interface  EmployeeService {

	Iterable<Employee> getAllEmployees();
	Employee getEmployee(Integer id);//update işleminde de kullanıyoruz.
	Employee addEmployee(Employee employee);//update işleminde de kullanıyoruz.
	boolean deleteEmployee(Integer id);
		
}
