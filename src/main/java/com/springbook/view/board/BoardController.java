package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	//검색 조건 목록 항목 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String>conditionMap = new HashMap<String, String>();
		
		conditionMap.put("내용", "content");
		conditionMap.put("제목", "title");
		
		return conditionMap;
	}
	
	@RequestMapping(value = "dataTransform.do")
	public List<BoardVO> dataTransform(BoardVO vo){
		vo.setSearchCondition("title");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = service.getBoardList(vo);
		return boardList;
	}
	

	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		
		
		
		MultipartFile uploadFile = vo.getUplodaFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:\\springworkspace\\upload\\" + fileName));
		}
		
		service.insertBoard(vo);
		return "redirect:getBoardList.do";
	}

	@RequestMapping("updateBoard.do")
	public String updateBoard(@ModelAttribute("board")BoardVO vo) {

		service.updateBoard(vo);
		return "redirect:getBoardList.do";
	}

	@RequestMapping("deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		service.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", service.getBoard(vo));
		return "getBoard.jsp";
	}
	@RequestMapping("getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		
		if(vo.getSearchCondition() == null) vo.setSearchCondition("title");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		model.addAttribute("boardList", service.getBoardList(vo));
		return "getBoardList.jsp";
	}
	

//	@RequestMapping("getBoardList.do")
//	public String getBoardList(
//			@RequestParam(value = "searchCondition", defaultValue = "title",required = false) String condition,
//			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword,
//			BoardVO vo, Model model) {
//		
//		System.out.println("검색조건 : " + condition);
//		System.out.println("검색내용 : " + keyword);
//		List<BoardVO> boardList = service.getBoardList(vo);
//		model.addAttribute("boardList", boardList);
//		return "getBoardList.jsp";
//	}
}
