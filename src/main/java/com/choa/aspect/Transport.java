package com.choa.aspect;

import org.springframework.stereotype.Component;

@Component
public class Transport {
	//핵심 로직 : 학원에 오기 위해 하는 행위 ( 어떻게 오느냐 )
	
	
	
	public void bus(){
		System.out.println("자리를 뺐었습니다.");
		System.out.println("옆사람 폰을 훔쳐 봅니다.");
		System.out.println("====================");
	}
	
	
	public void subway(){
		System.out.println("두리번 두리번");
		System.out.println("리니지 M을 실행 합니다.");
		System.out.println("공부를 하려다가 멈춥니다.");
	}
	
	
	
	
	
}
