package com.informatica.project.groupvalues.entity;

import java.util.Set;

/**
 * 
 * Entity class used to return the response
 * 
 * @author Vijayanak
 *
 */
public class CsvGroupingResponseEntity {

	private int groupNo;
	private Set<String> groupValues;

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public Set<String> getGroupValues() {
		return groupValues;
	}

	public void setGroupValues(Set<String> groupValues) {
		this.groupValues = groupValues;
	}

}
