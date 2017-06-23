package com.choa.notice;



import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.ListInfo;




@Repository
//NoticeDAO noticeDAO = new NoticeDAO()와 같다.
//멤버 변수 처리가 필요 @Inject 할것.
public class NoticeDAOImpl  implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE="NoticeMapper.";
	
	@Override
	public List<BoardDTO> boardList(ListInfo listInfo) throws Exception {
		return sqlSession.selectList(NAMESPACE+"List", listInfo);
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		BoardDTO boardDTO = sqlSession.selectOne(NAMESPACE+"View", num);
		return boardDTO;
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"Write", boardDTO); 
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"Update", boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		return sqlSession.delete(NAMESPACE+"Delete", num);
	}

	

	@Override
	public int boardCount(ListInfo listInfo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"Count", listInfo);
	
	}

	@Override
	public int boardHit(int num) throws Exception {
		return 0;
	}
}
