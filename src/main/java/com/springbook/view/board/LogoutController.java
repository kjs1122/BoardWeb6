package com.springbook.view.board;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class LogoutController{
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		
		session.invalidate();
		
		mav.setViewName("redirect:login.jsp");
		return mav;
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		
//		HttpSession session = request.getSession();
//		session.invalidate();
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("login.jsp");		
//		return mav;
//	}
//	
	

//	@Override
//	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		
//		HttpSession session = request.getSession();
//		
//		session.invalidate();
//		
//		return "login";
//	}

}
