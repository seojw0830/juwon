package com.pjt.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pjt.spring.member.Member;
import com.pjt.spring.member.service.MemberService;

@Controller
//@RequestMapping("/member") 경로를 묶어줌
public class MemberController {

//	MemberService service = new MemberService();
//	@Autowired
	@Resource(name="memService")
	MemberService service;
	
	@RequestMapping(value="/memJoin", method=RequestMethod.POST) // 폼에서 넘어오는 방식이 POST인 경우, GET방식은 똑같이 GET으로 써주던가 안써줘도된다.
	public String memJoin(Model model, HttpServletRequest request) {
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memMail = request.getParameter("memMail");
		String memPhone1 = request.getParameter("memPhone1");
		String memPhone2 = request.getParameter("memPhone2");
		String memPhone3 = request.getParameter("memPhone3");
		
		service.memberRegister(memId, memPw, memMail, memPhone1, memPhone2, memPhone3);
		
		model.addAttribute("memId", memId);
		model.addAttribute("memPw", memPw);
		model.addAttribute("memMail", memMail);
		model.addAttribute("memPhone", memPhone1 + " - " + memPhone2 + " - " + memPhone3);
		
		return "memJoinOk";
	}
	
	@RequestMapping(value="/memLogin", method=RequestMethod.POST)
//	public String memLogin(Model model, HttpServletRequest request) {
	public String memLogin(Model model, @RequestParam("memId") String memId, @RequestParam("memPw") String memPw)	{
//		String memId = request.getParameter("memId");
//		String memPw = request.getParameter("memPw");
		
		Member member = service.memberSearch(memId, memPw);
		
		try {
			model.addAttribute("memId", member.getMemId());
			model.addAttribute("memPw", member.getMemPw());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "memLoginOk";
	}
	
}