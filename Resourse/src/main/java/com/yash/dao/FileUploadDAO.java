package com.yash.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.yash.modal.Employee;

@Repository("fileUploadDAO")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "prototype")
public class FileUploadDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public FileUploadDAO(){
		System.out.println("fileUploadDAO");
	}
	
	public void saveEmp(Employee employee){
		sessionFactory.getCurrentSession().save(employee);
	}
	
	public List<EmployeeDTO> getAllEmployees(){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class, "employeeAlias");
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("employeeAlias.id").as("id"))
				.add(Projections.property("employeeAlias.name").as("name"))
				.add(Projections.property("employeeAlias.address").as("address"))
				).setResultTransformer(new AliasToBeanResultTransformer(EmployeeDTO.class));
		List<EmployeeDTO> employeeDTOs = criteria.list();
		return employeeDTOs;
	}
	public EmployeeDTO getEmployee(Integer id){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class, "employeeAlias");
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("employeeAlias.id").as("id"))
				.add(Projections.property("employeeAlias.name").as("name"))
				.add(Projections.property("employeeAlias.address").as("address"))
				).setResultTransformer(new AliasToBeanResultTransformer(EmployeeDTO.class));
		criteria.add(Restrictions.eq("employeeAlias.id", id));
		List<EmployeeDTO> employeeDTOs = criteria.list();
		return employeeDTOs.get(0);
	}
	public void updateEmployeeData(List<EmployeeDTO> employeeDTOs){
		for (EmployeeDTO employeeDTO : employeeDTOs) {
			Employee employee = new Employee();
			BeanUtils.copyProperties(employeeDTO, employee);
			sessionFactory.getCurrentSession().merge(employee);
		}
	}
	public void hibernateNativeQuery(){
		Query query = sessionFactory.getCurrentSession().createSQLQuery("select name from Emp");
		
		List<Object[]> list = query.list();
		
		
	}
	
}
