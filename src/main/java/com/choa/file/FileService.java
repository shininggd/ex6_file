package com.choa.file;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.choa.util.SeDTO;

@Service
public class FileService {
	
	//SeUpload
	public String seUpload(SeDTO seDTO, HttpSession session) throws Exception{
		String file_result = "";
		
		if(seDTO.getFiledata() != null && seDTO.getFiledata().getOriginalFilename() != null && !seDTO.getFiledata().getOriginalFilename().equals("")){
			FileSaver fileSaver = new FileSaver();
			String defaultPath = session.getServletContext().getRealPath("resources/upload");
			String realName = fileSaver.fileSave(defaultPath, seDTO.getFiledata());
		
			file_result = "&bNewLine=true&sFileName="+seDTO.getFiledata().getOriginalFilename()+"&sFileURL=/ex6/resources/upload/"+realName;
		
		}else {
			file_result = "&errstr=error";
		}
		
		return "redirect:"+seDTO.getCallback()+"?callback_func"+seDTO.getCallback_func()+file_result;
		
		
		
		
		
	}
	
	
	
	
	
	
	//파일삭제
	public Boolean fileDelete(String filename, HttpSession session) throws Exception{
		String realPath = session.getServletContext().getRealPath("resources/uload");
		File f = new File(realPath, filename);
		boolean result = f.delete();
		
		return result;
	}
	
	
	public String fileSave(MultipartFile mpf, HttpSession session) throws Exception{
		
		FileSaver fs = new FileSaver();
		
		String fileName = fs.fileSave(session.getServletContext().getRealPath("resources/upload"), mpf);
		
		return fileName;
		
	}
	
	
	
	
}
