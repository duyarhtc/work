package com.work.project.employee;
/*model employee*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;



@Entity
public class Employee {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String surname;
	private int salary;

	public Employee() {
	}
	
	
	public Employee( int id,String name, String surname, int salary) {
		super();
		this.id=id;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

}
