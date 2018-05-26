package io.alfredux.domain.service;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

import io.alfredux.domain.entity.CsvData;
import io.alfredux.domain.model.CsvHeader;
import io.alfredux.domain.repository.CsvDataRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CsvImportService {

	@Autowired
	CsvDataRepository csvDataRepository;
	
	@ServiceActivator
	public List<CsvData> importCsv(byte[] bytes){
		
		try {
			Reader in = new InputStreamReader(new ByteArrayInputStream(bytes));
			
			Iterable<CSVRecord> records = CSVFormat.RFC4180
					.withHeader(CsvHeader.class)
					.withFirstRecordAsHeader().parse(in);
			
			List<CsvData> csvDataList = new ArrayList<>();
			
			for (CSVRecord record : records) {
				log.info("{}",record);
				CsvData csvData = new CsvData();
				csvData.setId(record.get(CsvHeader.id));
				csvData.setUsername(record.get(CsvHeader.username));
				csvData.setPassword(record.get(CsvHeader.password));
				csvData.setAccessToken(record.get(CsvHeader.accessToken));
				csvDataList.add(csvData);		
			}	
			
			in.close();
		
			return csvDataRepository.saveAll(csvDataList);
        } catch (Exception e) {
        	log.error("Error loading csv file {}",e.getMessage());
        	throw new RuntimeException(e);
        }
		
	}
	
}
