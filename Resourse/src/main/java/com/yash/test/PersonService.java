package com.yash.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonService {

	
	private List<Person> persons;
	
	public PersonService() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		persons = mapper.readValue(new File("C:\\Users\\sudam.jadhav\\Documents\\persons.json"), new TypeReference<List<String>>() {});
	}
	
	
	public List<Person> searchePersonByName(String name){
		List<Person> list2 = persons.stream().filter(item->item.getName().equals(name)).collect(Collectors.toList());
		return list2;
	}
	
	
	public List<Person> searchePersonByEmail(String email){
		List<Person> list = persons.stream().filter(item->item.getEmail().equals(email)).collect(Collectors.toList());
		return list;
	}
	
	
	public List<Person> searchePersonAgeBetween(Integer minAge, Integer ageMax){
		List<Person> list = persons.stream().filter(item->item.getAge() > minAge && item.getAge() < ageMax).collect(Collectors.toList());
		return list;
	}
	
	public List<Person> searchePersonAgeGreaterThan(Integer age){
		List<Person> list = persons.stream().filter(item->item.getAge() > age).collect(Collectors.toList());
		return list;
	}
	
	public List<Person> searchePersonAgeLessThan(Integer age){
		List<Person> list = persons.stream().filter(item->item.getAge() < age).collect(Collectors.toList());
		return list;
	}
	
	public Long getMalePersonCount(){
		Long l = persons.stream().filter(item->item.getGender().equals("Male")).count();
		return l;
	}
	
	public Long getFemalePersonCount(){
		Long l = persons.stream().filter(item->item.getGender().equals("Female")).count();
		return l;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public static void main(String args[]) throws JsonParseException, JsonMappingException, IOException{
		PersonService personService = new PersonService();
		System.out.println(personService.searchePersonByName("Graig Powlowski"));
		System.out.println(personService.getFemalePersonCount());
		System.out.println(personService.getMalePersonCount());
		System.out.println(personService.searchePersonAgeGreaterThan(20));
		System.out.println(personService.searchePersonAgeBetween(20, 50));
		System.out.println(personService.searchePersonAgeGreaterThan(20));
		System.out.println(personService.searchePersonAgeLessThan(50));
		System.out.println(personService.searchePersonByEmail("janea@reichertlesch.io"));
	}
}
