package com.yash.resourse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yash.dao.EmployeeDTO;
import com.yash.dao.EmployeeList;
import com.yash.services.FileUploadService;

@RestController
@RequestMapping("/fileUploadController")
public class ExcelResource {

	
	@Autowired
	private  FileUploadService fileUploadService;  
	
	@Autowired
	private Integer integerBean;
	
	@Autowired
	private String stringBean;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value = "/home" , method = RequestMethod.GET)
	public ModelAndView home(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		System.out.println(integerBean);
		System.out.println(stringBean);
		return modelAndView;
	}
	
	@RequestMapping(value = "/upload" , method = RequestMethod.GET)
	public ModelAndView upload(ModelAndView modelAndView,HttpServletRequest request){
		fileUploadService.consumeService();
		modelAndView.setViewName("upload");
//		IOException
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/show" , method = RequestMethod.GET)
	public List<EmployeeDTO> show(){
		System.out.println(integerBean);
		System.out.println(stringBean);
		return fileUploadService.getAllEmployee();
	}
	
	@RequestMapping(value = "/getEmployee/{id}" , method = RequestMethod.GET)
	public EmployeeDTO getEmployee(@PathVariable("id") Integer id){
		return fileUploadService.getEmployee(id);
	}
	
	@RequestMapping(value = "/fileUpload" , method = RequestMethod.POST)
	public String putExcelFile(@RequestParam("file") MultipartFile file,ModelMap modelMap) throws IOException{
		InputStream inputStream = new ByteArrayInputStream(file.getBytes());
		fileUploadService.consumePostService(inputStream);
//		fileUploadService.updateFileInDataBase(inputStream);
		return  "Data Uploaded Successfully";
	}
	
	@RequestMapping(value = "/updateDataOnpaging" , method = RequestMethod.POST)
	public String updateDataOnpaging(@RequestBody EmployeeList employeeList,ModelMap modelMap) throws IOException{
		fileUploadService.updateEmployeeData(employeeList.getEmployeeDTOs());
		return  "Data Uploaded Successfully";
	}
	
	@RequestMapping(value = "/update" , method = RequestMethod.PUT)
	public String update(@RequestBody EmployeeList employeeList,ModelMap modelMap) throws IOException{
		fileUploadService.updateEmployeeData(employeeList.getEmployeeDTOs());
		return  "Data Uploaded Successfully";
	}

	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public String add(@RequestBody List<EmployeeDTO> employeeList,@ModelAttribute EmployeeDTO employee,ModelMap modelMap) throws IOException{
		fileUploadService.saveAllEmp(employeeList);
		return  "Data Uploaded Successfully";
	}
	
}
