package org.zerock.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.VO.KakaoVO;
import org.zerock.service.kakaoService.KakaoAPI;

@RequestMapping("/common")
@Controller
public class CommonController{

//2022.08.05 추가 : 만들어둔 서비스를 객체주입 받아 와야 한다.
//(2)번 게시물에서는 썻는데 여기는 빠졌었다! 
 @Autowired 
 KakaoAPI kakaoService;


  @RequestMapping(value = "/kakaologin")
    public String login(@RequestParam("code") String code, HttpSession session,  HttpServletRequest request) throws IOException {
         
        //토큰 발급 받기
		String access_Token = kakaoService.getAccessToken(code);
       
        //사용자 정보 가지고 오기 
		KakaoVO userInfo = kakaoService.userInfo(access_Token);
		
		//세션 형성
		session = request.getSession();
		
		System.out.println("accessToken: "+access_Token);
		System.out.println("code:"+ code);
		System.out.println("Common Controller:"+ userInfo);
		System.out.println("nickname: "+ userInfo.getNickname());
		System.out.println("email: "+ userInfo.getAccount_email());
		System.out.println("gender: "+ userInfo.getGender());
		
		
		//세션에 담기
		if (userInfo.getNickname() != null) {
		     session.setAttribute("nickname", userInfo.getNickname());
		     session.setAttribute("access_Token", access_Token);
		     session.setAttribute("kakaoId", userInfo.getKakaoId());
		   }
            
        return "common/kakao";
    }


}
