package com.choa.ex6;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.choa.file.FileDTO;
import com.choa.file.FileService;
import com.choa.file.MultiFileDTO;
import com.choa.file.SameMultiFileDTO;
import com.choa.util.SeDTO;

@Controller
@RequestMapping(value="/file/**")
public class FileController {
	
	//폼으로 연결
	@RequestMapping(value="fileUpload", method=RequestMethod.GET)
	public void fileUpload(){
		
	}
	//파일 다운로드
	//먼저 개념 잡기 ********
	@RequestMapping(value="fileDown", method=RequestMethod.GET)
	public ModelAndView fileDown(String filename,String oriname, HttpSession session){
		String realPath = session.getServletContext().getRealPath("resources/upload");
		File f = new File(realPath, filename);
		
		//다운로드 할수 있는 클래스로 연결해야 한다.
		ModelAndView mv = new ModelAndView();
		mv.setViewName("download");//뷰의 이름을 클래스명이랑 동일한 이름으로 해야한다.
		mv.addObject("oriname", oriname);
		mv.addObject("downloadFile", f);
		
		//뷰페이지로 가는 것이 아닌 다운로드가 되어야 한다.
		return mv;
	}
	
	
	//스마트에디터 파일 업로드
	@RequestMapping(value="seUpload", method=RequestMethod.POST)
	public String seUpload(SeDTO seDTO, HttpSession session) throws Exception{
		
		//callback 꺼내기
		String callback = seDTO.getCallback();
		//callback_func 꺼내기
		String callback_func = seDTO.getCallback_func();
		//Original Name 꺼내기
		String original_name = seDTO.getFiledata().getOriginalFilename();
		
		//defaultPath 잡기
		String defaultPath = session.getServletContext().getRealPath("resources/upload");
		
		/*File f = new File(defaultPath);
		//폴더(디렉터리)가 존재 하지 않을경우 디렉터리를 생성하겠습니다. 
		if(!f.exists()){
			f.mkdirs();
		}
		//디렉터리에 저장할 파일 명
		String realName = UUID.randomUUID().toString()+"_"+original_name;
		
		//받아온 파일을 디렉터리에 저장
		seDTO.getFiledata().transferTo(new File(f, realName));*/
		
		
		/*//최종적으로 서버에 있는 것을 리턴해준다.
		String file_result = "&bNewLine=true&sFileName="+original_name+"&sFileURL=/ex6/resources/upload/"+realName;
		
		
		return "redirect:"+callback+"?callback_func"+callback_func+file_result;*/
		
		FileService fs = new FileService();
		return fs.seUpload(seDTO, session);
	}
	
	//파일 삭제 컨트롤러
	@RequestMapping(value="fileDelete", method=RequestMethod.GET)
	public void fileDelete(String filename, HttpSession session) throws Exception{
		FileService fs = new FileService();
 		fs.fileDelete(filename, session);
 		
 		
	}
	
	//파라미터 이름을 모르거나 갯수를 모를떄 ( 유동적인 경우 )
	@RequestMapping(value="upload", method=RequestMethod.POST)
	public void upload(MultipartHttpServletRequest request){
		Iterator<String> it = request.getFileNames();
		ArrayList<MultipartFile> multi = new ArrayList<MultipartFile>();
		while(it.hasNext()){
			MultipartFile m = request.getFile(it.next());
			multi.add(m);
		}
		for(MultipartFile m : multi){
			System.out.println(m.getOriginalFilename());
		}
	}
	
	
	
	
	
	//1 멀티파트 파일의 배열로 받아서 꺼내본다 ( 파라미터 이름이 동일한게 2개 이상일 경우)
	@RequestMapping(value="sameMultiFileUpload", method=RequestMethod.POST)
	public void sameMultiFileUpload(MultipartFile [] f1){
		for(int i=0;i<f1.length;i++){
			System.out.println(f1[i].getOriginalFilename());
		}
	}

	
	
	//2번쨰
	public void sameMultiFileUpload(SameMultiFileDTO sdto){
		for(int i=0;i<sdto.getF1().length;i++){
			System.out.println(sdto.getF1()[i].getOriginalFilename());
		}
	}
	
	//3 request
	public void sameMultiFileUpload(MultipartHttpServletRequest request){
		List<MultipartFile> ar = request.getFiles("f1");
		for(MultipartFile f : ar){
			System.out.println(f.getOriginalFilename());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//다중 파일 업로드, 그리고 파라미터 이름이 다를경우(갯수가 고정되어 있을 경우)
	//1.
	@RequestMapping(value="multiFileUpload", method=RequestMethod.POST )
	public void multiFileUpload(MultiFileDTO multiFileDTO){
		System.out.println(multiFileDTO.getF1().getOriginalFilename());
		System.out.println(multiFileDTO.getF2().getOriginalFilename());
	}
	
	//2 멀티파일 객체 이용
	public void multiFileUpload(MultipartFile f1, MultipartFile f2){
		System.out.println(f1.getOriginalFilename());
		System.out.println(f2.getOriginalFilename());
	}
	//3 리퀘스트
	public void multiFileupload(MultipartHttpServletRequest request){
		MultipartFile f1 = request.getFile("f1");//리퀘스트로 받아올 경우에는 request.getfile(파라미터명)
		MultipartFile f2 = request.getFile("f2");
	}
	
	
	
	//단일 파일 업로드 일경우에 쓰는 방법
	//1 리퀘스트로 받는 방법
	
	public void fileUpload(MultipartHttpServletRequest request){
		
	}
	
	//2 파라미터명과 동일한 이름으로 멀티파트 로 받음
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public ModelAndView fileUpload(MultipartFile f1, HttpSession session) throws Exception{
		FileService fs = new FileService();
		String filename = fs.fileSave(f1, session);
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("file/fileView");
		mv.addObject("fileName", filename);
		mv.addObject("oriName", f1.getOriginalFilename());
		
		return mv;
	}
	
	//3 fileDTO 객체를 통해서 파일을 받는 방법
	public void fileUpload(FileDTO fileDTO){
		
	}
	
}
