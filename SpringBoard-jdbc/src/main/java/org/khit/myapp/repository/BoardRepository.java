package org.khit.myapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.khit.myapp.dto.BoardDTO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	//�۾��� ó��
	public void save(BoardDTO board) {
		conn = JDBCUtil.getConnection();
		String sql = "insert into boards(boardtitle, boardwriter, boardcontent) "
				+ "values(?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardWriter());
			pstmt.setString(3, board.getBoardContent());
			//����
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	
	public List<BoardDTO> getlistall(){
		List<BoardDTO> bl = new ArrayList<>();
		conn = JDBCUtil.getConnection();
		String sql = "select*from boards order by id desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setId(rs.getLong("id"));
				board.setBoardWriter(rs.getString("boardwriter"));
				board.setBoardTitle(rs.getString("boardtitle"));
				board.setBoardContent(rs.getString("boardcontent"));
				board.setCreateTime(rs.getTimestamp("createtime"));
				
				bl.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return bl;
		
	}
	
	public BoardDTO findbyId(Long id){
		BoardDTO board = new BoardDTO();
		conn = JDBCUtil.getConnection();
		String sql = "select*from boards where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				board.setId(rs.getLong("id"));
				board.setBoardWriter(rs.getString("boardwriter"));
				board.setBoardTitle(rs.getString("boardtitle"));
				board.setBoardContent(rs.getString("boardcontent"));
				board.setCreateTime(rs.getTimestamp("createtime"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return board;
		
	}
	

}
