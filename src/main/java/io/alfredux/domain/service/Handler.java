package io.alfredux.domain.service;

import java.io.File;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Handler {

	public String handleString(String input) {
		log.info("Copying text: " + input);
		return input;
	}
	
	public File handleFile(File input) {
		log.info("Copying file: " + input.getAbsolutePath());
		return input;
	}
	
	public byte[] handleBytes(byte[] input) {
		log.info("Copying " + input.length + " bytes ...");
		return input;
	}

}
