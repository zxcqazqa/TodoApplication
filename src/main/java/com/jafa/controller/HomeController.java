package com.jafa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jafa.domain.Today;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model, HttpSession session, Today today) {
		model.addAttribute("name", "봉준");
		Date date = new Date();
//		System.out.println("포맷전 : " + date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String formatDate = sdf.format(date);
//		System.out.println("날짜포맷후 : " + formatDate);
		
		today.setYear(Integer.parseInt(formatDate.substring(0, 4)));
		today.setMonth(Integer.parseInt(formatDate.substring(4, 6)));
		today.setDay(Integer.parseInt(formatDate.substring(6)));
		today.setToday(Integer.parseInt(formatDate));
//		System.out.println("오늘날짜 : " + today);
		session.setAttribute("today", today);
		return "home";
	}
}
