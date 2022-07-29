package com.spring.example.Login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.example.serviceImpl.MemberServiceImpl;

public class MemberController {
	 private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	 
	 @Autowired
	    private MemberServiceImpl memberServiceImpl;
	 
	 //회원가입 get
	
}
