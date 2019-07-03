package com.nav.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.yash.dao.EmployeeDTO;

public class ReadExcel {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		File file = new File("C:\\Users\\sudam.jadhav\\Desktop\\TestExcel1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = sheet.rowIterator();
		List<EmployeeDTO> dtos = new ArrayList<>();
		
		while (iterator.hasNext()) {
			EmployeeDTO dto = new EmployeeDTO();
			Row row = iterator.next();
			dto.setName(row.getCell(0).getStringCellValue());
			dto.setAddress(row.getCell(1).toString());
			dto.setDesignation(row.getCell(2).getStringCellValue());
			dtos.add(dto);
		}
		List<EmployeeDTO> dtos2 = new ArrayList<>();
		for (EmployeeDTO dto : dtos) {
			if(dto.getDesignation().equals("Manager")){
				dtos2.add(dto);
			}
		}
		
		System.out.println(dtos2);
		
		System.out.println(dtos);
	}

}
