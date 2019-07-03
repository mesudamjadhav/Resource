package com.yash.dao;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employee")
public class EmployeeDTO {

	private Integer id;
	
	private String name;
	
	private String address;
	
	private String designation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", name=" + name + ", address=" + address + ", designation=" + designation
				+ "]";
	}
	
	
}
