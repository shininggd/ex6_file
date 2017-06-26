package com.choa.ex6;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.board.BoardDTO;
import com.choa.memo.MemoDAO;
import com.choa.memo.MemoDTO;
import com.choa.notice.NoticeDAOImpl;
import com.choa.util.ListInfo;

public class DTOTEST extends MyAbstarctTestUnit{

	@Autowired
	private MemoDAO memoDAO;
	
	@Test
	public void test() throws Exception{
		ListInfo listInfo = new ListInfo();
		List<MemoDTO> ar = memoDAO.boardList(listInfo);
		assertNotNull(ar);
	}

}
