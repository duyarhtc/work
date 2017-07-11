package com.work.project.department;

/*Model Department*/

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import com.work.project.employee.Employee;

@Entity
public class Department {
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	 
	   private Integer id;
       private String name;
	   private String description;
		
	  @OneToOne
	   private Employee employee;
		
		public Department(Integer id,String name, String description, Integer empid) {
			super();
			
			this.id=id;
			this.name = name;
			this.description = description;
			this.employee = new Employee(empid,"", "", 0);
		}

	public Department() {
	}
	
    public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	
	
	
}
