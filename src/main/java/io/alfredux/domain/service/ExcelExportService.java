package io.alfredux.domain.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import io.alfredux.domain.entity.CsvData;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("exportExcelService")
public class ExcelExportService {
	
	public void exportExcel(List<CsvData> data) {
		
		File outputFile = new File("filesystem/output/csvdata-"+System.currentTimeMillis()+".xls");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("MAIN");
        
        log.info("Creating excel");

        int rowNum = 0;
        for (CsvData csvData : data) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            row.createCell(colNum++).setCellValue(csvData.getId());
            row.createCell(colNum++).setCellValue(csvData.getUsername());
            row.createCell(colNum++).setCellValue(csvData.getPassword());
            row.createCell(colNum++).setCellValue(csvData.getAccessToken());
        }

        try {
        	log.info("Saving file into {}",outputFile.getParentFile().getAbsolutePath());
        	outputFile.getParentFile().mkdirs();
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
        	log.error(e.getMessage(),e);
        }
        
        log.info("Done");
		
	}
}
