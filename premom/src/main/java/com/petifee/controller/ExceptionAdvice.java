package com.petifee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.petifee.exception.ArticleNotFound;

@ControllerAdvice	
public class ExceptionAdvice {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView common(Exception e){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/errorPage");
		mav.addObject("title", "에러 발생");
		mav.addObject("msg", "메시지 : " + e.getMessage());
		return mav;
	}
	
	@ExceptionHandler(ArticleNotFound.class)
	public ModelAndView articleNF(ArticleNotFound e){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/errorPage");
		mav.addObject("title", "글읽기 에러");
		mav.addObject("msg", "메시지 에러 : " + e.getMessage());
		return mav;
	}


}
