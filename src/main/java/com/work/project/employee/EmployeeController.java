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
	
	/*Thymeleaf elamanlarından çağırabilmek için model formarında return değerleri oluşturuyoruz*/
	
	
	@RequestMapping(value="/employees", method=RequestMethod.GET)//tüm employee sıralıyoruz
	
	   public String GetAllEmployees(Model model){
		
	        model.addAttribute("employees",employeeservice.getAllEmployees());
	        System.out.println("Returning remployees:");
	         return "employees"; //employees.html
	    }
	
	@RequestMapping("employee/new")//employee yapısında bi nesne oluşturuyoruz .Değerleri girmek için form yapısındaki htmle gönderiyoruz
    public String newEmployee(Model model){
        model.addAttribute("employee", new Employee());
        
        return "employeeform"; //employeeform.html
    }
	
	
	
	@RequestMapping(value = "employee", method = RequestMethod.POST)//ekleme yapıyoruz
    public String AddEmployee(Employee employee){
		employeeservice.addEmployee(employee);
        return "redirect:/employee/" + employee.getId();//example:employe/2 link
    }

	    
	 @RequestMapping("/employee/{id}")//id si verilen emp getiriyoruz
	    public String GetEmployee(@PathVariable int id,Model model){
		    model.addAttribute("employee",employeeservice.getEmployee(id));
			return "employeeshow";//employeeshow.html
			}
	 
	    
	    @RequestMapping(value="/employee/update/{id}")//seçilen emp alıp bizi form ekranına gönderiyor oradan tekrar save yapıyoruz
	    public String UpdateEmployee(Model model,@PathVariable int id){
	    	model.addAttribute("employee",employeeservice.getEmployee(id));
	    	 return "employeeform";//employeeform.html veri girişi için 
	    	
	    }
	    
	    @RequestMapping(value="/employee/delete/{id}")// delete işlemi yapıyoruz 
	    public String DeleteEmployee(@PathVariable int id,Model model){
	    	employeeservice.deleteEmployee(id);
	    	model.addAttribute("employees",employeeservice.getAllEmployees());
	    	return "employees";//silinen veri kontrolü için tüm listeyi getiren employees.html
	    	
	    }
	    
	   
	    
}
