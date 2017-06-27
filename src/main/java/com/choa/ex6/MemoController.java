package com.choa.ex6;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.util.ListInfo;

@Controller
@RequestMapping(value="/memo/**")
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	
	@RequestMapping(value="memoList", method=RequestMethod.GET)
	public void memoList(){
		
	}
	
	@RequestMapping(value="getMemoList/{curPage}/{find}/{search}/", method=RequestMethod.GET)
	@ResponseBody
	public List<MemoDTO> memoList(@PathVariable("curPage")Integer curPage, @PathVariable("find") String find,@PathVariable("search") String search) throws Exception{
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(curPage);
		listInfo.setFind(find);
		listInfo.setSearch(search);
		List<MemoDTO> ar = memoService.boardList(listInfo);
		
		
		
		return ar;
		//데이터를 리턴하면 알아서 제이슨 형식으로 바꿔준다는 의미이다.
		
	}
	
	@RequestMapping(value="memoWrite", method=RequestMethod.POST)
	@ResponseBody
	public List<MemoDTO> memoWrite(MemoDTO memoDTO, Model model)throws Exception{
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(1);
		int result = memoService.boardWrite(memoDTO);	
		List<MemoDTO> ar = memoService.boardList(listInfo);
		
		
		return ar;
		
	}
	
	
	@RequestMapping(value="memoView/{num}")
	@ResponseBody//Ajax로 보내주고 싶은 데이터를 제이슨 형태로 바꿔주는 어노테이션
	public MemoDTO memoView(@PathVariable("num") int num) throws Exception{
		MemoDTO memoDTO = memoService.boardView(num);
		return memoDTO;
		//@PathVariable 경로 변수 restful 에 쓰이는 방식
	}
	
	
	
	
}
