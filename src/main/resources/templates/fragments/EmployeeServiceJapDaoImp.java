package com.work.project.employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpadao")
public class EmployeeServiceJapDaoImp implements EmployeeService {
	
	private EntityManagerFactory emf;
	
	@Autowired
	private EmployeeReporsity employeerepository;

	
	
	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public Iterable<Employee> getAllEmployees(){
		EntityManager em=emf.createEntityManager();
		return em.createQuery("from Employee",Employee.class).getResultList();
	}

		
		
	@Override
	public Employee getEmployee(Integer id){//update işleminde de kullanıyoruz.
		EntityManager em=emf.createEntityManager();
		return em.find(Employee.class, id);
		
	}

	@Override
	public Employee addEmployee(Employee employee) {//update işleminde de kullanıyoruz.
		EntityManager em=emf.createEntityManager();
	   em.getTransaction().begin();
	   Employee saveemployee=em.merge(employee);
	   em.getTransaction().commit();
	   return saveemployee;
	  
	}

	@Override
	public boolean deleteEmployee(Integer id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Employee.class, id));
		em.getTransaction().commit();
		return true;
		
		
		
		
	}
	
	
	

}
