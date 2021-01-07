package com.training.hamburger.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AdminOperation<T> implements Administration<T> {
	
	public static final Logger logger = LogManager.getLogger(AdminOperation.class.getName());

	@Override
	public void create(T entity) throws IOException {
		
		String strFilename = getFileName(entity.getClass().getName());
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(entity);
		
		try (BufferedWriter out = new BufferedWriter(new FileWriter(strFilename))) {
			out.append(json);
			out.flush();
		} catch (IOException ex) {
			logger.error(ex);
			throw ex;
		}
	}


	private String getFileName(String entityName) {
		String fileName = null;
		Date now = new Date();
		
		if (entityName.equals("com.training.hamburger.repository.Location")) {
			fileName = "location_"+now.getTime()+".json";
		} else if (entityName.equals("com.training.hamburger.repository.Menu")) {
			fileName = "menu_"+now.getTime() +".json";
		}
		
		return fileName;
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public T list() {
		// TODO Auto-generated method stub
		return null;
	}

}
