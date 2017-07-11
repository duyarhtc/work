package com.work.project.meeting;
/*Model Meeting*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.work.project.department.Department;

@Entity
public class Meeting {
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
		 
	    private Integer id;
	    private String name;
		private String description;
		@OneToOne //departman her meetingse katılabilir.Aynı zamnda birden fazla meeting ile eşlebilir
		private Department department;
		
	
		public Meeting() {
		}
		public Meeting(Integer id,String name, String description, Integer depid) {
			super();
			
			this.id=id;
			this.name = name;
			this.description = description;
			this.department = new Department(depid,"" ,"", 0);
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

		

 
	
	
	
}
