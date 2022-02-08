package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOSpring{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//insert, update, delete -> update()
	//select -> queryForInt(), queryForObject, query()
	
	private static final String BOARD_INSERT = "insert into board(seq, title, writer, content) "
			+ "values((select nvl(max(seq),0)+1 from board), ?, ?, ?)";
//	private static final String BOARD_INSERT = "insert into board(seq, title, writer, content) "
//			+ "values(?, ?, ?, ?)";
	
	private static final String BOARD_SELECT = "select * from board order by seq desc";
	private static final String BOARD_SELECT_SEQ = "select * from board where seq = ?";
	private static final String BOARD_CNT = "update board set cnt = cnt + 1 where seq = ?";
	
	private static final String BOARD_LIST_T = "select * from board where title like '%' ||?|| '%' order by seq desc";
	private static final String BOARD_LIST_C = "select * from board where content like '%' ||?|| '%' order by seq desc";
	
	private static final String BOARD_UPDATE = "update board set title = ?, writer = ?, content = ? where seq = ?";
	
	private static final String BOARD_DELETE = "delete from board where seq = ?";
	
	//CRUD
	
	//글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");	
		jdbcTemplate.update(BOARD_INSERT,vo.getTitle(),vo.getWriter(),vo.getContent());
	}




	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 updataBoard() 기능 처리");	
		jdbcTemplate.update(BOARD_UPDATE,vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getSeq());
	}


	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");	
		Object[] args = {vo.getSeq()};
		jdbcTemplate.update(BOARD_DELETE, args);
	}


	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
		Object[] args = {vo.getSeq()};
		
		jdbcTemplate.update(BOARD_CNT,vo.getSeq());
		return jdbcTemplate.queryForObject(BOARD_SELECT_SEQ, args, new BoardRowMapper());
	}


	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");
		if (vo.getSearchCondition().equals("title")) {
			Object[] args = {vo.getSearchKeyword()};
			System.out.println("title 검색");
			return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
		} else if (vo.getSearchCondition().equals("content")) {
			Object[] args = {vo.getSearchKeyword()};
			System.out.println("content 검색");
			return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
		}
		return jdbcTemplate.query(BOARD_SELECT, new BoardRowMapper());
	}

}
