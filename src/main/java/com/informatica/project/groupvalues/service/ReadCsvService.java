package com.informatica.project.groupvalues.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;


/**
 * Service interface that exposes the method that contain business logic
 * 
 * @author Vijayanak
 *
 */
public interface ReadCsvService {

	public List<List<String>> readCsv() throws FileNotFoundException, Exception;
	
	public List<Set<String>> formGroup(List<List<String>> list);

}
