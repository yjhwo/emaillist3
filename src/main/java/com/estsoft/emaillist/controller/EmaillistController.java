package com.estsoft.emaillist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.estsoft.emaillist.dao.EmailListDAO;

// 이 application 접근을 다른 것으로 하고싶으면 controller mapping해주면 된다.
@Controller
public class EmaillistController {
	
	@Autowired
	private EmailListDAO dao;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index(){
		System.out.println(dao);		// new를 안 했는데도 자동으로 생성이 되서 주입이 된 것을 확인할 수 있다. (DI;Autowired annotation을 이용함)
		return "emaillist";
	}
	
}
