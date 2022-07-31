package com.spring.example;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.test.KakaoLoginOutput;
import com.spring.test.httpConnection;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
httpConnection conn = httpConnection.getInstance();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/kakaologin", method = RequestMethod.GET)
	public String kakao() {
		StringBuffer loginUrl = new StringBuffer();
		loginUrl.append("https://kauth.kakao.com/oauth/authorize?client_id=");
		loginUrl.append("4ac87beec7cd58d826123c7ac093d8ec"); //移댁뭅�삤 �빋�뿉 �엳�뒗 REST KEY
		loginUrl.append("&redirect_uri=");
		loginUrl.append("http://localhost:8080/kakaoLogin"); //移댁뭅�삤 �빋�뿉 �벑濡앺븳 redirect URL
		loginUrl.append("&response_type=code");
		
		return "redirect:"+loginUrl.toString();
	}
	
	@RequestMapping(value = "/kakaoLogin", method = RequestMethod.GET) // 濡쒓렇�씤 �꽦怨듭떆 kakaoLogin
	public String redirect(@RequestParam String code, HttpSession session) throws IOException {
		
		//code
		//�궗�슜�옄媛� 痍⑥냼 �늻瑜대㈃ error �뙆�씪硫뷀꽣瑜� 諛쏆쓬 
		// 洹몃븣 �뿬湲곗꽌 援щ텇�빐�빞�븷�벏
		Map<String, String> map = new HashMap<String, String>();
		map.put("grant_type", "=authorization_code");
		map.put("client_id", "=4ac87beec7cd58d826123c7ac093d8ec"); //移댁뭅�삤 �빋�뿉 �엳�뒗 REST KEY
		map.put("redirect_uri", "=http://localhost:8080/kakaoLogin"); //移댁뭅�삤 �빋�뿉 �벑濡앺븳 redirect URL
		map.put("code", "="+code);
		
		String out = conn.HttpPostConnection("https://kauth.kakao.com/oauth/token", map).toString();
		
		ObjectMapper mapper = new ObjectMapper();
		KakaoLoginOutput output = mapper.readValue(out, KakaoLoginOutput.class);
		
		System.out.println(output);
		session.setAttribute("access_token", output.getAccess_token());
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/kakaologout")
	public String access(HttpSession session) throws IOException {
		
		String access_token = (String)session.getAttribute("access_token");
		Map<String, String> map = new HashMap<String, String>();
		map.put("Authorization", "Bearer "+ access_token);
		
		String result = conn.HttpPostConnection("https://kapi.kakao.com/v1/user/logout", map).toString();
		System.out.println(result);
		
		return "redirect:/";
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
}
