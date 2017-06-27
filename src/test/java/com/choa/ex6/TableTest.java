package com.choa.ex6;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.table.TableADTO;
import com.choa.table.TableService;

public class TableTest extends MyAbstarctTestUnit{
	@Autowired
	private TableService tableService;
	@Test
	public void test() throws Exception{
		TableADTO adto = new TableADTO();
		int num = 2;
		adto.setNum(num);
		adto.setTitle("dodo2");
		adto.setWriter("dodorian2");
		int result =tableService.insertTable(adto, 1);
		assertNotEquals(0, result);
	}

}
