package com.spring.example.VO;

public class KakaoVO {

	private Long kakaoId;
	private String nickname;
	private String account_email;
	
	
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAccount_email() {
		return account_email;
	}
	public void setAccount_email(String account_email) {
		this.account_email = account_email;
	}
	
	public Long getKakaoId() {
		return kakaoId;
	}
	public void setKakaoId(Long kakaoId) {
		this.kakaoId = kakaoId;
	}
	
}



