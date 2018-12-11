package com.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.login.service.LoginService;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public ModelAndView checkUser(HttpServletRequest request, HttpServletResponse response) {
		String uName=request.getParameter("uName");
		String pwd=request.getParameter("pwd");		
		ModelAndView mv=new ModelAndView();
		LoginService lService=new LoginService();
		if(lService.checkUser(uName, pwd)) {
			mv.setViewName("success.jsp");
			mv.addObject("user", uName);
		} else {
			mv.setViewName("failure.jsp");
		}
		//int count=lService.saveInDB(uName, pwd);
//		ModelAndView mv=new ModelAndView();
//		if(count!=0) {
//			System.out.println("total rows effected in db " + count);
//			mv.setViewName("success.jsp");
//			mv.addObject("user", uName);
//		} else {
//			mv.setViewName("failure.jsp");
//		}
		
		return mv;
	}

}
