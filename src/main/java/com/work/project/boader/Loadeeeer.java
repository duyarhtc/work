package com.work.project.boader;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.work.project.department.Department;
import com.work.project.department.DepartmentReporsity;
import com.work.project.employee.Employee;
import com.work.project.employee.EmployeeRepository;
import com.work.project.meeting.Meeting;
import com.work.project.meeting.MeetingReporsity;




@Component
public class Loadeeeer implements ApplicationListener<ContextRefreshedEvent> {
	 private EmployeeRepository employeerepository;
	 private Logger log = Logger.getLogger(Loadeeeer.class);
	 
	 private DepartmentReporsity departmentrepository;
	private Logger log1=Logger.getLogger(Loadeeeer.class);
	
	private MeetingReporsity meetingrepositrory;
	private Logger log2=Logger.getLogger(getClass());
	 
	
	 
	 @Autowired
	 public void setEmployeeLoader(EmployeeRepository emReporsity){
		 this.employeerepository=emReporsity;
		 
    }
	 
	 @Autowired
	 public void setDepartmentLoader(DepartmentReporsity depReporsity){
		 this.departmentrepository=depReporsity;
	 }
	
	 @Autowired
	 public void setMeetingLoader(MeetingReporsity meReporsity){
		 this.meetingrepositrory=meReporsity;
	 }
	 
	
	 @Override
	    public void onApplicationEvent(ContextRefreshedEvent event) {
		 Employee emp=new Employee();
		 //emp.setEid(String.valueOf(emp.getId()));
		 emp.setName("Hatice");
		 emp.setSurname("Duyar");
		 emp.setSalary(3000);
		 
		 employeerepository.save(emp);
		//log.info("saved emp id:" +emp.getId());
		 
		 Department dep=new Department();
		 dep.setName("software");
		 dep.setDescription("coder");
		 dep.setEmployee(emp);
		 
		
		 
		 Employee emp1=new Employee();
		// emp1.setEid(String.valueOf(emp1.getId()));
		 emp1.setName("Ali");
		 emp1.setSurname("Veli");
		 emp1.setSalary(3500);
		 
		 employeerepository.save(emp1);
		 //log.info("saved emp id:" +emp1.getName());
		 
		 Department dep1=new Department();
		 dep1.setName("hardware");
		 dep1.setDescription("machine");
		 dep1.setEmployee(emp1);
		 
		 
		 departmentrepository.save(dep);
		 //log.info("saved emp id:" +dep.getId());
		 
		 departmentrepository.save(dep1);
		 //log.info("saved emp id:" +dep1.getId());
		 
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
