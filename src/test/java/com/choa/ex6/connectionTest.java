package com.choa.ex6;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class connectionTest extends MyAbstarctTestUnit{

	@Autowired
	private SqlSession sqlsession;
	
	
	@Test
	public void test() {
		assertNotNull(sqlsession);
	}

}
