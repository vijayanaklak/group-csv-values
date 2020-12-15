package com.informatica.project.groupvalues.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;

/**
 * ReadCsvServiceImpl is the service implementation of ReadCsvService .
 * This Service reads from source.csv and groups the values .
 * 
 * @author Vijayanak
 *
 */
@Service
public class ReadCsvServiceImpl implements ReadCsvService {

	@Override
	public List<List<String>> readCsv() throws FileNotFoundException, Exception {
		return readDataFromCSV();
	}

	/**
	 * this private method is to read the source.csv file and pass the read value to 
	 * another method formGroup 
	 * 
	 * @return List<Set<String>>
	 */
	private static List<List<String>> readDataFromCSV() {
		List<List<String>> list = new ArrayList<>();
		FileReader filereader;
		try {
			filereader = new FileReader("source.csv");
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			List<String> innerList = null;
			while ((nextRecord = csvReader.readNext()) != null) {
				innerList = new ArrayList<String>();
				for (String cell : nextRecord) {
					innerList.add(cell);
				}
				list.add(innerList);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	/**
	 * 
	 * This is the core method in this class that contains the business logic to form
	 * groups from the CSV values read by readDataLineByLine
	 * 
	 * @param list
	 * @return List<Set<String>>
	 */
	public List<Set<String>> formGroup(List<List<String>> list) {
		List<Set<String>> resultList = new ArrayList<>();
		Set<String> groupSet = new HashSet<String>();
		Set<String> previous = new HashSet<String>();
		for (int i = 0; i < list.size(); i++) {
			List<String> current = list.get(i);
			if (i == 0) {
				previous.addAll(current);
				groupSet.addAll(current);
				continue;
			}
			if (!chkContain(previous, current)) {
				resultList.add(groupSet);
				groupSet = new HashSet<>();
			}
			groupSet.addAll(current);
			previous = new HashSet<String>();
			previous.addAll(current);
		}
		resultList.add(groupSet);
		return resultList;
	}

	/**
	 * utility method to check the values are present in the previous row
	 * 
	 * @param previous Set<String>
	 * @param current List<String>
	 * @return boolean
	 */
	private static boolean chkContain(Set<String> previous, List<String> current) {
		for (int j = 0; j < current.size(); j++) {
			if (previous.contains(current.get(j))) {
				return true;
			}
		}
		return false;
	}

}
