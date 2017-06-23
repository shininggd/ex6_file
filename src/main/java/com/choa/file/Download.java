package com.choa.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class Download extends AbstractView {
	//일반 클래스가 아니라 view 객체의 역할을 해야한다.
	// 그 역할을 주기 위해서 스프링에서 제공하는 abstractview 라는 클래스를 상속 받는다.
	
	public Download() {
		setContentType("application/download;charset=UTF-8");//다운로드를 준비하라는 의미
		
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)throws Exception {
		File f = (File)model.get("downloadFile");//model에 담을떄는 object 타입이기 떄문에 file로 형변환 필요
		String oriname = (String)model.get("oriname");
		response.setCharacterEncoding(getContentType());
		response.setContentLength((int)f.length());//f.length 는 long 타입이기 떄문에 int로 형변환
		
		String filename = URLEncoder.encode(f.getName(), "UTF-8");
		filename = filename.substring(filename.lastIndexOf("_")+1);
		//String filename = URLEncoder.encode(f.getName(), "UTF-8");// 파일명을 꺼내오는 것. 한글이 깨질수 있는 가능성이 있기 때문에 인코딩을 맞추어 준다.
		response.setHeader("Content-Disposition", "attachment;filename=\""+filename+"\"" );
		response.setHeader("Content-Transfer-Encoding", "binary");//파일을 2진데이터로 바꾸어서 간다는 의미
		
		OutputStream out = response.getOutputStream();//response를 socket으로 보면 된다.
		
		FileInputStream fi = null;
		
		fi= new FileInputStream(f);
		
		FileCopyUtils.copy(fi, out);
		
		fi.close();
		out.close();
		//파일 다운로드 처리하는 View 객체  따라서 컨트롤러에서 이 클래스를 호출해야 한다.
	}
}
