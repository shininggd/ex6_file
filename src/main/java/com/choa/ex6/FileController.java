package com.choa.ex6;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.choa.file.FileDTO;
import com.choa.file.MultiFileDTO;
import com.choa.file.SameMultiFileDTO;

@Controller
@RequestMapping(value="/file/**")
public class FileController {
	
	//폼으로 연결
	@RequestMapping(value="fileUpload", method=RequestMethod.GET)
	public void fileUpload(){
		
	}
	//파라미터 이름을 모르거나 갯수를 모를떄 ( 유동적인 경우 )
	
	
	
	
	
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
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public void fileUpload(MultipartHttpServletRequest request){
		
	}
	
	//2 파라미터명과 동일한 이름으로 멀티파트 로 받음
	public void fileUpload(MultipartFile f1){
		
	}
	
	//3 fileDTO 객체를 통해서 파일을 받는 방법
	public void fileUpload(FileDTO fileDTO){
		
	}
	
}
