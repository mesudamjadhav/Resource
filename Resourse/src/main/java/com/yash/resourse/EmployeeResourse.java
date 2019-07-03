package com.yash.resourse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yash.modal.Employee;



@Path("employeeResourse")
@Consumes(value=MediaType.APPLICATION_JSON)
@Produces(value={MediaType.TEXT_XML , MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.TEXT_PLAIN })
public class EmployeeResourse {

	
	@POST
	@Path("/add")
//	@Produces(value={MediaType.TEXT_XML})
	public Employee addEmployee(Employee employee){
		return employee;
	}
}
