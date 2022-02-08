package com.springbook.view.board;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class DeleteBoardController{
	
	@RequestMapping("deleteBoard.do")
	public ModelAndView deleteBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		boardDAO.deleteBoard(vo);
		
		mav.setViewName("redirect:getBoardList.do");
		return mav;
	}
	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		int seq = Integer.parseInt(request.getParameter("seq"));
//		
//		BoardVO vo = new BoardVO();
//		vo.setSeq(seq);
//		
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.deleteBoard(vo);
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
//	}
	
	
	
	

//	@Override
//	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		int seq = Integer.parseInt(request.getParameter("seq"));
//		
//		BoardVO vo = new BoardVO();
//		vo.setSeq(seq);
//		
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.deleteBoard(vo);
//		
//		return "getBoardList.do";
//	}

}
