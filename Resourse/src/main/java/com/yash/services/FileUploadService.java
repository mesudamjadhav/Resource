package com.yash.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestOperations;

import com.yash.dao.EmployeeDTO;
import com.yash.dao.EmployeeList;
import com.yash.dao.FileUploadDAO;
import com.yash.modal.Employee;

@Service("fileUploadService")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "prototype")
public class FileUploadService  {
	
	
	@Autowired	
	private FileUploadDAO fileUploadDAO;
	
	@Autowired
	private RestOperations restTemplate;
	
	public FileUploadService() {
		System.out.println("fileUploadService");
	}
	
	@Transactional(readOnly = false , propagation = Propagation.REQUIRED)
	public void updateFileInDataBase(InputStream file) throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook(file); 
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			Row row = iterator.next();
			if(row.getRowNum() == 1){
				continue;
			}
			
			Employee employee = new Employee();
			employee.setName(row.getCell(1).toString());
			employee.setAddress(row.getCell(2).toString());
			fileUploadDAO.saveEmp(employee);
		}
		workbook.close();
	}
	
	@Transactional(readOnly=true, propagation = Propagation.REQUIRED)
	public List<EmployeeDTO> getAllEmployee() {
		fileUploadDAO.hibernateNativeQuery();
		return fileUploadDAO.getAllEmployees();
	}
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void updateEmployeeData(List<EmployeeDTO> employeeDTOs) {
		fileUploadDAO.updateEmployeeData(employeeDTOs);
	}
	
	
	public EmployeeDTO [] consumeService(){
//		RestTemplate restTemplate = new RestTemplate(); //10.8.101.45
//        ResponseEntity<List<EmployeeDTO>> entity = 
		
		ParameterizedTypeReference<List<EmployeeDTO>> reference = new ParameterizedTypeReference<List<EmployeeDTO>>(){};
		
//		HttpEntity<EmployeeList> entity = new HttpEntity<EmployeeList>(new EmployeeList());
//		ResponseEntity<List<EmployeeDTO>> forObject = restTemplate.exchange(
//				  "http://10.8.101.45:8080/Resourse/fileUploadController/show",
//				  HttpMethod.GET,
//				  Entity.entity(entity, mediaType) ,
//				  reference);
		
		ParameterizedTypeReference<List<EmployeeDTO>> parameterizedTypeReference = new ParameterizedTypeReference<List<EmployeeDTO>>(){};
		parameterizedTypeReference.getType();
		
//		List<EmployeeDTO> employeeDTOs = forObject.getBody();
//        ResponseEntity<EmployeeDTO> entity = new ResponseEntity<EmployeeDTO>();  
//        return employeeDTOs;
        return null;
	}
	
	public void consumePostService(InputStream file) throws IOException{
		
		XSSFWorkbook workbook = new XSSFWorkbook(file); 
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = sheet.iterator();
		List<EmployeeDTO> employees = new ArrayList<>();
		while (iterator.hasNext()) {
			Row row = iterator.next();
			if(row.getRowNum() == 1){
				continue;
			}
			
			EmployeeDTO employee = new EmployeeDTO();
			employee.setName(row.getCell(1).toString());
			employee.setAddress(row.getCell(2).toString());
//			fileUploadDAO.saveEmp(employee);
			employees.add(employee);
		}
		workbook.close();
		EmployeeList employeeList = new EmployeeList();
		employeeList.setEmployeeDTOs(employees);
		
//		Client client = ClientBuilder.newClient();
//		Response response = client.target("http://10.8.101.45:8080/Resourse/fileUploadController/add").request().post(Entity.entity(employeeList, MediaType.APPLICATION_JSON));
		
//		String string = restTemplate.postForObject("http://10.8.101.45:8080/Resourse/fileUploadController/add",employeeList, String.class);
		HttpEntity<List<EmployeeDTO>> entity = new HttpEntity<>(employees);
		Map<String, Object> map = new HashMap<>();
		EmployeeDTO employee = new EmployeeDTO();
		employee.setName("My New Emp");
		
		map.put("employee", "My New Employee");
		ResponseEntity<String> forObject = restTemplate.exchange(
				  "http://10.8.100.126:8080/Resourse/fileUploadController/add?name={employee}",
				  HttpMethod.POST,
				  entity ,
				  String.class,map);
		
	}
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void saveAllEmp(List<EmployeeDTO> employeeDTOs){
		for (EmployeeDTO employeeDTO : employeeDTOs) {
			Employee employee = new Employee();
			BeanUtils.copyProperties(employeeDTO, employee);
			fileUploadDAO.saveEmp(employee);
		}
	}

	public FileUploadDAO getFileUploadDAO() {
		return fileUploadDAO;
	}

	public void setFileUploadDAO(FileUploadDAO fileUploadDAO) {
		this.fileUploadDAO = fileUploadDAO;
	}
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public EmployeeDTO getEmployee(Integer id){
		return fileUploadDAO.getEmployee(id);
	}
	
}
