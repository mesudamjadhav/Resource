package com.nav.scripts;

public class Student extends Guru implements Comparable<Guru> {
	
	Integer id;
	String name;
	Address address;
	
	Student(int id,String name,Address address){
		this.id=id;
		this.name=name;
		this.address=address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	@Override
	public int compareTo(Guru o) {
		int str = this.name.compareTo(((Student)o).getName());
		int id =  this.id.compareTo(((Student)o).getId());
		return str - id  ;
	}
	
	

}
