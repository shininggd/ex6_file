package com.choa.file;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileSaver {
	
	//파일을 저장하는 첫번쨰 방법
	public String fileSave(String realPath, byte [] fileData, String oriName) throws Exception{
		File file = new File(realPath);
		
		if(!file.exists()){
			file.mkdirs();
		}
		
		//실제 upload 폴더에 저장되는 파일 이름
		String fileName = UUID.randomUUID().toString()+"_"+oriName;
		
		File target = new File(file, fileName);
		
		//파일 저장
		FileCopyUtils.copy(fileData, target);
		
		return fileName;
		
		
	}
	
	//2번째 multiParFile에 있는 클래스를 이용한다.
	public String fileSave(String realPath, MultipartFile mpf) throws Exception{
		System.out.println(realPath);
		File f = new File(realPath);
		if(!f.exists()){
			f.mkdirs();
		}
		//UUID 클래스를 만들떄는 다음과 같이 한다.  ** 파일명이 중복만 되지 않으면 된다. 시간으로도 할수 있다.
		//파일명을 중복시키지 않기 위한 방법.
		String fileName = UUID.randomUUID().toString()+"_"+mpf.getOriginalFilename();
		//2
		/*Calendar ca = Calendar.getInstance();
		String fileName = ca.getTimeInMillis()+"_"+mpf.getOriginalFilename();*/
		
		File target = new File(f, fileName);
		mpf.transferTo(target);//target 쪽으로 파일을 전송하겠따 라는 의미.
		
		return fileName;
	}
	
}
