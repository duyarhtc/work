package com.work.project.department;

/* URL Mapping and html file call*/


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
	
	/*html  ve Thymeleaf içinde değerlere ulaşmak için Model yapısını kullanıyoruz*/
	
	@RequestMapping(value="/departments",method=RequestMethod.GET)
	public String GetAllDepartments(Model model){
		model.addAttribute("departments", departmentservice.getAllDepartments());
		return "departments";
	}
	
	@RequestMapping("department/new")//department yapısında bi nesne oluşturuyoruz
    public String newDepartment(Model model){
        model.addAttribute("department", new Department());
        return "departmentform";
    }
	
	 @RequestMapping("/department/{id}")//id si verilen department getiriyoruz//update ve delete işleminde de kullanıyoruz
	    public String GetDepartment(Model model,@PathVariable Integer id){
		 model.addAttribute("department", departmentservice.getDepartment(id));
			return "departmentshow";
			}
	 
	    @RequestMapping(method=RequestMethod.POST,value="department")// post işlemi ile yeni department ekliyoruz //update işleminde de kullanıyoruz
	    public String AddDepartment(Model model,Department department){
	    	model.addAttribute("department",departmentservice.addDepartment(department));
	    	return "redirect:/department/" + department.getId();
	    	
	    }
	    
	    @RequestMapping(value="/department/update/{id}")//seçilen department alıp bizi form ekranına gönderiyor oradan tekrar save yapıyoruz
	    public String UpdateDepartment(Model model,@PathVariable int id){
	    	model.addAttribute("department",departmentservice.getDepartment(id));
	    	 return "departmentform";
	    	
	    }
	    
	    
	    @RequestMapping("/department/delete/{id}")//delete yapıyoruz 
	    public String DeleteDepartment(Model model,@PathVariable Integer id){
	    	departmentservice.deleteDepartment(id);
	    	model.addAttribute("departments",departmentservice.getAllDepartments() );
	        return "departments"; //veri kontolü için tüm listeyi olduğu html sayfasını çağırıyoruz
	    	
	    }
	

}
