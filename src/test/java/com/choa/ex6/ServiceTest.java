package com.choa.ex6;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.util.ListInfo;

public class ServiceTest extends MyAbstarctTestUnit {

	@Autowired
	private MemoService memoService;
	
	@Test
	public void test() throws Exception{
		ListInfo listInfo = new ListInfo();
		
		List<MemoDTO> ar = memoService.boardList(listInfo);
		
		assertNotNull(ar);
	}
}
