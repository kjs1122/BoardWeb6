package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {
	@RequestMapping(method = RequestMethod.GET, value = "/login.do")
	public String loginView(UserVO vo) {
		vo.setId("test");
		vo.setPassword("test1234");
		
		return "login.jsp";
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/login.do")
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다");
			
		}
		
		
		UserVO user = userDAO.getUser(vo);
		
		
		if(user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("로그인처리");
//
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//
//		UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(vo);
//
//		ModelAndView mav = new ModelAndView();
//		
//		if(user != null) {
//			mav.setViewName("redirect:getBoardList.do");
//		} else {
//			mav.setViewName("redirect:login.jsp");
//		}
//		
//		return mav;
//	}

//	@Override
//	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		System.out.println("로그인처리");
//		
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//		
//		UserDAO dao = new UserDAO();
//		UserVO user = dao.getUser(vo);
//		
//		if(user != null) {
//			return "getBoardList.do";
//		} else {
//			return "login";
//		}
//	}

}
