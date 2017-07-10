package com.work.project.meeting;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MeetingController {
	@Autowired//meeting service ile bağlantı sağlıyoruz
	private MeetingService meetingservice;
	
	/*Thymeleaf elamanlarından çağırabilmek için model formarında return değerleri oluşturuyoruz*/
	
	
	@RequestMapping(value="/meetings",method=RequestMethod.GET)//tüm meetings getiriyoruz
	public String GetAllMeetings(Model model){
		model.addAttribute("meetings", meetingservice.getAllMeetings());
		return "meetings";//meetings.html
	}
	
	@RequestMapping("meeting/new")//meeting yapısında bi nesne oluşturuyoruz 
    public String newMeeting(Model model){
        model.addAttribute("meeting", new Meeting());
        return "meetingform"; //meetingsform.html
    }
	
	 @RequestMapping("/meeting/{id}")//id si verilen meeting getiriyoruz
	    public String GetMeeting(Model model,@PathVariable Integer id){
		 model.addAttribute("meeting", meetingservice.getMeeting(id));
			return "meetingshow";//meetingshow.html
			}
	 
	    @RequestMapping(method=RequestMethod.POST,value="meeting")//post işlemi ile yeni meeting ekliyoruz
	    public String AddMeeting(Model model,Meeting meeting){
	    	model.addAttribute("meeting",meetingservice.addMeeting(meeting));
	    	return "redirect:/meeting/" + meeting.getId();//example:meeting/1 linki ne gidiyoruz
	    	
	    }
	    
	    @RequestMapping(value="/meeting/update/{id}")//seçilen emp alıp bizi form ekranına gönderiyor oradan tekrar save yapıyoruz
	    public String UpdateMeeting(Model model,@PathVariable Integer id){
	    	model.addAttribute("meeting",meetingservice.getMeeting(id));
	    	 return "meetingform";//meetingform.html e gidip yeni değerleri giriyoruz
	    	
	    }
	    
	    
	    @RequestMapping("meeting/delete/{id}")// silme yapıyoruz 
	    public String DeleteMeeting(Model model,@PathVariable Integer id){
	    	meetingservice.deleteMeeting(id);
	    	model.addAttribute("meetings",meetingservice.getAllMeetings() );
	        return "meetings";//meetings.html sayfasını çağırarak tüm listeyi getiriyoruz.kontrolü sağlamak için 
	    	
	    }
	
	

}
