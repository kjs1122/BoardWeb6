package com.springbook.view.board;

import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class InsertBoardController {

	
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		String writer = request.getParameter("writer");
//		
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setContent(content);
//		vo.setWriter(writer);
		
		boardDAO.insertBoard(vo);
		
		return "redirect:getBoardList.do";
	}

	
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		String writer = request.getParameter("writer");
//		
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setContent(content);
//		vo.setWriter(writer);
//		
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.insertBoard(vo);
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
//	}

	
	
	
	
	
	
//	@Override
//	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		String writer = request.getParameter("writer");
//		
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setContent(content);
//		vo.setWriter(writer);
//		
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.insertBoard(vo);
//		
//		return "getBoardList.do";
//	}

}
