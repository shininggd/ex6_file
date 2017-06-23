package com.choa.util;

public class ListInfo {
	
	private Integer curPage;
	private Integer perPage;
	
	//Row 처리
	private String search;
	private String find;
	private int startRow;
	private int lastRow;
	//page 처리
	private int curBlock;
	private int totalBlock;
	private int startNum;
	private int lastNum;

	public void makePage(int totalCount){
		//1. totalPage구하기
		int totalPage=0;
		int perBlock=5;
		
		if(totalCount%this.getPerPage()==0){
			totalPage = totalCount/this.getPerPage();
		}else {
			totalPage = totalCount/this.getPerPage()+1;
		}
		//2.totalBlock
		if(totalPage%perBlock==0){
			totalBlock = totalPage/perBlock;
		}else {
			totalBlock = totalPage/perBlock+1;
		}
		//3.curBlock
		if(this.getCurPage()%perBlock==0){
			curBlock = this.getCurPage()/perBlock;
		}else {
			curBlock = this.getCurPage()/perBlock+1;
		}
		//4.startnum, lastnum
		startNum = (curBlock-1)*perBlock+1;
		lastNum = curBlock*perBlock;
		//
		if(curBlock==totalBlock){
			lastNum=totalPage;
		}
		
	}
	
	public int getCurBlock() {
		return curBlock;
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public int getStartNum() {
		return startNum;
	}

	public int getLastNum() {
		return lastNum;
	}

	public int getStartRow() {
		return startRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	
	//makeRow 만들기
	public void makeRow(){
		startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		lastRow = this.getCurPage()*this.getPerPage();
	}
	
	public Integer getCurPage() {
		if(curPage==null){
			curPage=1;
		}
		return curPage;
	}
	
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPerPage() {
		if(perPage==null){
			perPage=10;
		}
		return perPage;
	}
	
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getFind() {
		return find;
	}
	public void setFind(String find) {
		this.find = find;
	}
	
}
