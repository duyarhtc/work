package com.work.project.meeting;
/*service and CRUD function*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.project.department.Department;




@Service
public class MeetingService {

	
	@Autowired
	private MeetingRepository meetingrepository;
	
	
	
	public Iterable<Meeting> getAllMeetings(){
		return meetingrepository.findAll();
	}
	
	
	public Meeting getMeeting(Integer id){
		return meetingrepository.findOne(id);
		
	}

	
	public Meeting addMeeting(Meeting meeting) {
	   return  meetingrepository.save(meeting);
	}

	

	public boolean deleteMeeting(Integer id) {
		
		
		meetingrepository.delete(id);
		return true;
		
		
	}

}
