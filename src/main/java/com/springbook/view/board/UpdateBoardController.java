package com.springbook.view.board;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class UpdateBoardController{
	
	@RequestMapping("updateBoard.do")
	public ModelAndView updateBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		boardDAO.updateBoard(vo);
		
		mav.setViewName("redirect:getBoardList.do");
		return mav;
	}
	
	
	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		int seq = Integer.parseInt(request.getParameter("seq"));
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		String writer = request.getParameter("writer");
//		
//		BoardVO vo = new BoardVO();
//		vo.setSeq(seq);
//		vo.setTitle(title);
//		vo.setContent(content);
//		vo.setWriter(writer);
//		
//		BoardDAO boardDAO = new BoardDAO();
//		
//		boardDAO.updateBoard(vo);
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
//	}

	
	
	
	
	
	
	
	
//	@Override
//	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		int seq = Integer.parseInt(request.getParameter("seq"));
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		String writer = request.getParameter("writer");
//		
//		BoardVO vo = new BoardVO();
//		vo.setSeq(seq);
//		vo.setTitle(title);
//		vo.setContent(content);
//		vo.setWriter(writer);
//		
//		BoardDAO boardDAO = new BoardDAO();
//		
//		boardDAO.updateBoard(vo);
//		
//		return "getBoardList.do";
//	}

}
