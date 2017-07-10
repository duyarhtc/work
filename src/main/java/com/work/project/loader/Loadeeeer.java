package com.work.project.loader;


/* starting load employee,department and meeting example*/

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.work.project.department.Department;
import com.work.project.department.DepartmentRepository;
import com.work.project.employee.Employee;
import com.work.project.employee.EmployeeRepository;
import com.work.project.meeting.Meeting;
import com.work.project.meeting.MeetingRepository;




@Component
public class Loadeeeer implements ApplicationListener<ContextRefreshedEvent> {
	 private EmployeeRepository employeerepository;
	 private Logger log = Logger.getLogger(Loadeeeer.class);
	 
	 private DepartmentRepository departmentrepository;
	private Logger log1=Logger.getLogger(Loadeeeer.class);
	
	private MeetingRepository meetingrepositrory;
	private Logger log2=Logger.getLogger(getClass());
	 
	
	 
	 @Autowired
	 public void setEmployeeLoader(EmployeeRepository emReporsity){
		 this.employeerepository=emReporsity;
		 
    }
	 
	 @Autowired
	 public void setDepartmentLoader(DepartmentRepository depReporsity){
		 this.departmentrepository=depReporsity;
	 }
	
	 @Autowired
	 public void setMeetingLoader(MeetingRepository meReporsity){
		 this.meetingrepositrory=meReporsity;
	 }
	 
	
	 @Override
	    public void onApplicationEvent(ContextRefreshedEvent event) {
		 Employee emp=new Employee();
		 emp.setName("Hatice");
		 emp.setSurname("Duyar");
		 emp.setSalary(3000);
		 
		 employeerepository.save(emp);
	
		 Department dep=new Department();
		 dep.setName("software");
		 dep.setDescription("coder");
		 dep.setEmployee(emp);
		 
		
		 
		 Employee emp1=new Employee();
	     emp1.setName("Ali");
		 emp1.setSurname("Veli");
		 emp1.setSalary(3500);
		 
		 employeerepository.save(emp1);
	
		 
		 Department dep1=new Department();
		 dep1.setName("hardware");
		 dep1.setDescription("machine");
		 dep1.setEmployee(emp1);
		 
		 
		 departmentrepository.save(dep);
		 
		 
		 departmentrepository.save(dep1);
		
		 Meeting mee=new Meeting();
		 mee.setName("meeting1");
		 mee.setDescription("About Software");
		 mee.setDepartment(dep);
		 
		 
		 Meeting mee1=new Meeting();
		 mee1.setName("meeting2");
		 mee1.setDescription("About machine");
		 mee1.setDepartment(dep1);
		 
		 meetingrepositrory.save(mee);
		 meetingrepositrory.save(mee1);
		 
		 
	 }
		 
		 
		 
	



}
