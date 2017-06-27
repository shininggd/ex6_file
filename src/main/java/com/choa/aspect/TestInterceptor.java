package com.choa.aspect;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.choa.board.BoardDTO;
import com.choa.util.ListInfo;


public class TestInterceptor extends HandlerInterceptorAdapter{// 인터셉터 사용하기 위해선 이 클래스를 상속받아야함

	@Override// 컨트롤러 빠져나올때 사용됨 (디스패쳐 서블릿으로 간다) 그래서 리턴 타입이 없다.
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Controller 나온 후");
		Map<String, Object> map = modelAndView.getModel();
		Object list = map.get("list");
		Object listInfo = map.get("listInfo");
		Object board = map.get("board");
		System.out.println(((List<BoardDTO>)list).get(1000).getWriter());
		
		System.out.println(((ListInfo)listInfo).getCurPage());
		System.out.println(board);
		
		
	}

	@Override // 컨트롤러 가기전에 실행
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("Controller 가기전에 실행");
		return true;
		// true로 하면 리턴이 되고 false면 안된다.
	}
	

}
