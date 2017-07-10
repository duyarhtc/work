package com.work.project.department;

/*mapping and service configuration*/


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.work.project.employee.Employee;
import com.work.project.employee.EmployeeService;



@Controller
public class DepartmentController {
	@Autowired//department servise ile bağlantı sağlıyoruz
	private DepartmentService departmentservice;
	
	/*Thymeleaf elamanlarından çağırabilmek için model formarında return değerleri oluşturuyoruz*/
	
	
	@RequestMapping(value="/departments",method=RequestMethod.GET)//tüm departmenların sıralanması 
	public String GetAllDepartments(Model model){
		model.addAttribute("departments", departmentservice.getAllDepartments());
		return "departments";//fonk sonucunu departments.html dosyasına gönderiyoruz.
	}
	
	@RequestMapping("department/new")//department yapısında bi nesne oluşturuyoruz
    public String newDepartment(Model model){
        model.addAttribute("department", new Department());
        return "departmentform";//değerleri girmek için departmentform.html dosyasına yolluyoruz
    }
	
	 @RequestMapping("/department/{id}")//id si verilen department getiriyoruz
	    public String GetDepartment(Model model,@PathVariable Integer id){
		 model.addAttribute("department", departmentservice.getDepartment(id));
			return "departmentshow"; // departmentshow.html
			}
	 
	    @RequestMapping(method=RequestMethod.POST,value="department")// post işlemi ile yeni department  ekliyoruz 
	    public String AddDepartment(Model model,Department department){
	    	model.addAttribute("department",departmentservice.addDepartment(department));
	    	return "redirect:/department/" + department.getId();//ekleme işlemi bittikten sonra verilen linke gönderiyoruz 
	    	
	    }
	    
	    @RequestMapping(value="/department/update/{id}")//seçilen departmanı alıp bizi form ekranına gönderiyor oradan tekrar save yapıyoruz
	    public String UpdateDepartment(Model model,@PathVariable int id){
	    	model.addAttribute("department",departmentservice.getDepartment(id));
	    	 return "departmentform"; //departmentform.html
	    	
	    }
	    
	    
	    @RequestMapping("/department/delete/{id}")// silme işlemini  yapıyoruz 
	    public String DeleteDepartment(Model model,@PathVariable Integer id){
	    	departmentservice.deleteDepartment(id);
	    	model.addAttribute("departments",departmentservice.getAllDepartments() );
	        return "departments";//veri kontrolü için tüm listeyi getiren departments.html 
	    	
	    }
	

}
