package com.informatica.project.groupvalues;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.informatica.project.groupvalues.service.ReadCsvService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class GroupValuesApplicationTests {
	
	@Test
	void shouldReturnOneGroup() throws FileNotFoundException, Exception {
		
		ReadCsvService csvService = mock(ReadCsvService.class);
		
		List<String> innerList1 = new ArrayList<>();
		innerList1.add("1");
		innerList1.add("2");
		
		List<String> innerList2 = new ArrayList<>();
		innerList2.add("2");
		innerList2.add("3");
		
		List<String> innerList3 = new ArrayList<>();
		innerList3.add("3");
		innerList3.add("4");
		
		List<List<String>> list = new ArrayList<>();
		list.add(innerList1);
		list.add(innerList2);
		list.add(innerList3);
		
		given(csvService.readCsv()).willReturn(list);
		
		List<Set<String>> result = csvService.formGroup(list);
		
		assertEquals(1, result.size());
		
	}
	
	@Test
	void shouldReturnThreeGroups() throws FileNotFoundException, Exception {
		
		ReadCsvService csvService = mock(ReadCsvService.class);
		
		List<String> innerList1 = new ArrayList<>();
		innerList1.add("1");
		
		List<String> innerList2 = new ArrayList<>();
		innerList2.add("2");
		
		List<String> innerList3 = new ArrayList<>();
		innerList3.add("3");
		
		List<List<String>> list = new ArrayList<>();
		list.add(innerList1);
		list.add(innerList2);
		list.add(innerList3);
		
		given(csvService.readCsv()).willReturn(list);
		
		List<Set<String>> result = csvService.formGroup(list);
		
		assertEquals(3, result.size());
		
	}

}
