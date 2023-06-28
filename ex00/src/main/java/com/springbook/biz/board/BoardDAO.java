package com.springbook.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {

	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// SQL 명령어
	private final String BOARD_INSERT = "insert into board(seq, title, writer,content) values((select nvl(max(seq),0)+1 from board), ?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq =?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = " select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	//CRUD 기능 메소드 구현
	public void insert(BoardVO vo)
	{
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, stmt, conn);
		}
	}
	
	public void update(BoardVO vo)
	{
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());

			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(null, stmt, conn);
		}
	}
	
	public void delete(BoardVO vo)
	{
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());

			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(null, stmt, conn);
		}
	}
	
	public BoardVO getBoard(int seq)
	{
		
		BoardVO vo = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, seq);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCnt(rs.getInt("cnt"));
				vo.setRegDate(rs.getDate("regDate"));
			}

			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return vo;
	}
	
	public List<BoardVO> getBoardList()
	{
		List<BoardVO> list = null;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			
			rs = stmt.executeQuery();
			
			list = new ArrayList<BoardVO>();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCnt(rs.getInt("cnt"));
				vo.setRegDate(rs.getDate("regDate"));
				list.add(vo);
			}

		} catch (Exception e) {
			list = null;
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return list;
	}

}
