package com.informatica.project.groupvalues.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informatica.project.groupvalues.entity.CsvGroupingResponseEntity;
import com.informatica.project.groupvalues.service.ReadCsvService;


/**
 * CsvGroupingController is to find number of groups and group values .
 * Grouping is done based on the following conditions .
 * 
 * CSV document referred is source.csv 
 * 
 * Ex : Case 1 : 1	2
 *               2	3
 *               
 *      Groups - 1, Group Values = [1,2,3]          
 * 
 *      Case 2 : 1	1
 *               2	2
 *               3	3
 *               	
 *      Groups - 3, Group Values = [[1],[2],[3]]
 * 
 * @author Vijayanak
 *
 */

@RestController
public class CsvGroupingController {

	@Autowired
	private ReadCsvService readCsvService;

	/**
	 * GET method to retrieve groups from the given CSV
	 * CSV doc referred is source.csv
	 * 
	 * @return CsvGroupingResponseEntity
	 */
	@GetMapping("/informatica/groupsFromCsv")
	public List<CsvGroupingResponseEntity> csvRead() {

		List<CsvGroupingResponseEntity> resultList = new ArrayList<>();
		try {
			List<List<String>> list = readCsvService.readCsv();
			List<Set<String>> groupList = readCsvService.formGroup(list);
			for (int i = 0; i < groupList.size(); i++) {
				CsvGroupingResponseEntity entity = new CsvGroupingResponseEntity();
				entity.setGroupNo(i + 1);
				entity.setGroupValues(groupList.get(i));
				resultList.add(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
