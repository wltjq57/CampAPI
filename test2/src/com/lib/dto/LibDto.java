package com.lib.dto;

public class LibDto {
	private String addr1;
	private String addr2;
	private String caraSiteCo;
	private String facltNm;
	private String featureNm;
	private String firstImageUrl;
	private String induty;
	private String intro;
	private String lineIntro;
	private String mapX;
	private String mapY;

	public LibDto() {
		super();
	}
	
	public LibDto(String addr1, String addr2,String caraSiteCo, String facltNm, String featureNm, String firstImageUrl, String induty, String intro, String lineIntro, String mapX, String mapY) {
		super();
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.caraSiteCo = caraSiteCo;
		this.facltNm = facltNm;
		this.featureNm = featureNm;
		this.firstImageUrl = firstImageUrl;
		this.induty = induty;
		this.intro = intro;
		this.lineIntro = lineIntro;
		this.mapX = mapX;
		this.mapY = mapY;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getCaraSiteCo() {
		return caraSiteCo;
	}

	public void setCaraSiteCo(String caraSiteCo) {
		this.caraSiteCo = caraSiteCo;
	}

	public String getFacltNm() {
		return facltNm;
	}

	public void setFacltNm(String facltNm) {
		this.facltNm = facltNm;
	}

	public String getFeatureNm() {
		return featureNm;
	}

	public void setFeatureNm(String featureNm) {
		this.featureNm = featureNm;
	}

	public String getFirstImageUrl() {
		return firstImageUrl;
	}

	public void setFirstImageUrl(String firstImageUrl) {
		this.firstImageUrl = firstImageUrl;
	}

	public String getInduty() {
		return induty;
	}

	public void setInduty(String induty) {
		this.induty = induty;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getLineIntro() {
		return lineIntro;
	}

	public void setLineIntro(String lineIntro) {
		this.lineIntro = lineIntro;
	}

	public String getMapX() {
		return mapX;
	}

	public void setMapX(String mapX) {
		this.mapX = mapX;
	}

	public String getMapY() {
		return mapY;
	}

	public void setMapY(String mapY) {
		this.mapY = mapY;
	}

}
