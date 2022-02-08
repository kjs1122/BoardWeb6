package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Repository
public class BoardDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static final String BOARD_INSERT = "insert into board(seq, title, writer, content) "
			+ "values((select nvl(max(seq),0)+1 from board), ?, ?, ?)";
	
	private static final String BOARD_SELECT = "select * from board";
	private static final String BOARD_SELECT_SEQ = "select * from board where seq = ?";
	private static final String BOARD_LIST_T = "select * from board where title like '%' ||?|| '%' order by seq desc";
	private static final String BOARD_LIST_C = "select * from board where content like '%' ||?|| '%' order by seq desc";
	
	private static final String BOARD_UPDATE = "update board set title = ?, writer = ?, content = ? where seq = ?";
	
	private static final String BOARD_DELETE = "delete from board where seq = ?";
	
	private static final String BOARD_CNT = "update board set cnt = cnt + 1 where seq = ?";	
	//글등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			System.out.println("insert 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}//insertBoard
	
	//하나의 게시글만 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		BoardVO board = new BoardVO();
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement(BOARD_CNT);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(BOARD_SELECT_SEQ);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setCnt(rs.getInt("cnt"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		
		return board;
	}
		
	
	//글조회
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			if (vo.getSearchCondition().equals("title")) {
				pstmt = conn.prepareStatement(BOARD_LIST_T);
				System.out.println("title 검색");
			} else if (vo.getSearchCondition().equals("content")) {
				pstmt = conn.prepareStatement(BOARD_LIST_C);
				System.out.println("content 검색");
			}
			pstmt.setString(1, vo.getSearchKeyword());
			System.out.println(vo.getSearchKeyword() + "키워드 검색");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setCnt(rs.getInt("cnt"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}	
		return boardList;
	}//getBoardList
	
	
	//글 업데이트
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}//updateBoard
	
	
	//글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}

	}//deleteBoard
	

	
	
}
