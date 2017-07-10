package com.work.project.employee;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
	@Autowired//employee servise ile bağlantı sağlıyoruz
	private EmployeeService employeeservice;
	
	
	@RequestMapping(value="/employees", method=RequestMethod.GET)//tüm employee sıralıyoruz
	
	   public String GetAllEmployees(Model model){
		
	        model.addAttribute("employees",employeeservice.getAllEmployees());
	        System.out.println("Returning remployees:");
	         return "employees";
	    }
	
	@RequestMapping("employee/new")//employee yapısında bi nesne oluşturuyoruz
    public String newEmployee(Model model){
        model.addAttribute("employee", new Employee());
        
        return "employeeform";
    }
	
	
	
	@RequestMapping(value = "employee", method = RequestMethod.POST)//ekleme yapıyoruz/////////////////////////
    public String AddEmployee(Employee employee){
		employeeservice.addEmployee(employee);
        return "redirect:/employee/" + employee.getId();
    }

	    
	 @RequestMapping("/employee/{id}")//id si verilen emp getiriyoruz
	    public String GetEmployee(@PathVariable int id,Model model){
		    model.addAttribute("employee",employeeservice.getEmployee(id));
			return "employeeshow";
			}
	 
	    
	    @RequestMapping(value="/employee/update/{id}")//seçilen emp alıp bizi form ekranına gönderiyor oradan tekrar save yapıyoruz
	    public String UpdateEmployee(Model model,@PathVariable int id){
	    	model.addAttribute("employee",employeeservice.getEmployee(id));
	    	 return "employeeform";
	    	
	    }
	    
	    @RequestMapping(value="/employee/delete/{id}")//body kısmında delete işlemi ile delete yapıyoruz 
	    public String DeleteEmployee(@PathVariable int id,Model model){
	    	employeeservice.deleteEmployee(id);
	    	model.addAttribute("employees",employeeservice.getAllEmployees());
	    	return "employees";
	    	
	    }
	    
	   
	    
}
