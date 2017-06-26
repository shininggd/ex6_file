package com.choa.memo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.util.ListInfo;

@Repository
public class MemoDAO {

	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "MemoMapper.";
	
	//list
	public List<MemoDTO> boardList(ListInfo listInfo) throws Exception{
		return sqlSession.selectList(NAMESPACE+"List", listInfo);
	}
	//insert
	public int boardWrite(MemoDTO memoDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"Write", memoDTO);
	}
	//view
	public MemoDTO boardView(Integer num) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"View", num);
	}
	//update
	public int boardUpdate(MemoDTO memoDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"Update", memoDTO);
	}
	//delete
	public int boardDelete(Integer num) throws Exception{
		return sqlSession.delete(NAMESPACE+"Delete", num);
	}
	//count
	public int boardCount(ListInfo listInfo)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"Count", listInfo);
	}
}
