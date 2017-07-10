package com.work.project.meeting;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MeetingController {
	@Autowired//department servise ile bağlantı sağlıyoruz
	private MeetingService meetingservice;
	
	
	@RequestMapping(value="/meetings",method=RequestMethod.GET)
	public String GetAllMeetings(Model model){
		model.addAttribute("meetings", meetingservice.getAllMeetings());
		return "meetings";
	}
	
	@RequestMapping("meeting/new")//employee yapısında bi nesne oluşturuyoruz
    public String newMeeting(Model model){
        model.addAttribute("meeting", new Meeting());
        return "meetingform";
    }
	
	 @RequestMapping("/meeting/{id}")//id si verilen emp getiriyoruz
	    public String GetMeeting(Model model,@PathVariable Integer id){
		 model.addAttribute("meeting", meetingservice.getMeeting(id));
			return "meetingshow";
			}
	 
	    @RequestMapping(method=RequestMethod.POST,value="meeting")//body kısmında post işlemi ile yeni employee ekliyoruz 
	    public String AddMeeting(Model model,Meeting meeting){
	    	model.addAttribute("meeting",meetingservice.addMeeting(meeting));
	    	return "redirect:/meeting/" + meeting.getId();
	    	
	    }
	    
	    @RequestMapping(value="/meeting/update/{id}")//seçilen emp alıp bizi form ekranına gönderiyor oradan tekrar save yapıyoruz
	    public String UpdateMeeting(Model model,@PathVariable Integer id){
	    	model.addAttribute("meeting",meetingservice.getMeeting(id));
	    	 return "meetingform";
	    	
	    }
	    
	    
	    @RequestMapping("meeting/delete/{id}")//body kısmında delete işlemi ile delete yapıyoruz 
	    public String DeleteMeeting(Model model,@PathVariable Integer id){
	    	meetingservice.deleteMeeting(id);
	    	model.addAttribute("meetings",meetingservice.getAllMeetings() );
	        return "meetings";
	    	
	    }
	
	

}
