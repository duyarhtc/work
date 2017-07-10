package com.work.project.meeting;



import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface MeetingReporsity extends CrudRepository< Meeting , Integer > {
	
	public List<Meeting> findByDepartmentId(Integer depid);
		
	

}
