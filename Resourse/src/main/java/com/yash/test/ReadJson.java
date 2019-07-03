package com.yash.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		 Map<String, Object> customers = mapper.readValue(new File("G:\\Workspace\\Resourse\\src\\main\\webapp\\resources\\jsonFile.json"), new TypeReference<Map<String,Object>>() {});

		 Map<String, Object> map = (Map<String, Object>)customers.get("lotto");
		 
		 List<Object> list = (List<Object>)map.get("winners");
		 
		 Map<String, Object> map2 = (Map<String, Object>) list.get(0);
		 
		 System.out.println(map.get("winners"));
		 for (Entry<String, Object> entry : customers.entrySet()) {
				System.out.println(entry);
			
		}
	}
}
