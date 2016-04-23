package com.estsoft.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.estsoft.emaillist.dao.EmailListDAO;
import com.estsoft.emaillist.vo.EmailListVO;

// 이 application 접근을 다른 것으로 하고싶으면 controller mapping해주면 된다.
@Controller
public class EmaillistController {
	
	@Autowired
	private EmailListDAO dao;
	
	@RequestMapping("/form")
	public String form(){
		return "/WEB-INF/views/form.jsp";
	}
	
//	@RequestMapping(value="/insert", method=RequestMethod.POST)
//	public String insert(
//			@RequestParam(value="fn",required=true,defaultValue="")String firstName,
//			@RequestParam(value="ln",required=true,defaultValue="")String lastName,
//			@RequestParam(value="email",required=true,defaultValue="")String email){
//		
//		EmailListVO vo = new EmailListVO();
//		vo.setEmail(email);
//		vo.setFirstName(firstName);
//		vo.setLastName(lastName);
//		
//		dao.insert(vo);
//		
//		return "redirect:/index";
//	}
	// POST,GET 2가지 방법 다 갖고싶은경우, value값은 같게하고 함수를 2개만들면 됨
	
	// 간단한 방법
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute EmailListVO vo){	// 변수 이름과 form의 변수 이름이 일치해야 함!!※※※
		
		dao.insert(vo);
		
		return "redirect:/index";
	}
	
	
	@RequestMapping("/index")
	public String index(Model model){
		//System.out.println(dao);		// new를 안 했는데도 자동으로 생성이 되서 주입이 된 것을 확인할 수 있다. (DI;Autowired annotation을 이용함)
		
		// ------------------- new DAO 안 해줘도 됨
		List<EmailListVO> list = dao.getList();
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping("/index2")
	public ModelAndView index(){
		
		List<EmailListVO> list = dao.getList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("/WEB-INF/views/index.jsp");
		
		return mav;
	}
}
