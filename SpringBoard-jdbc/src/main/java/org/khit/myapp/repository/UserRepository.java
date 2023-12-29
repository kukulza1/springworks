package org.khit.myapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.khit.myapp.dto.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void save(UserDTO u) {
		conn = JDBCUtil.getConnection();
		String sql = "insert into users(userid , userpasswd, username, userage) "
				+ "values(?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUserid());
			pstmt.setString(2, u.getUserpasswd());
			pstmt.setString(3, u.getUsername());
			pstmt.setInt(4, u.getUserage());
			//½ÇÇà
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}

	public UserDTO login(UserDTO userDTO) {
		conn = JDBCUtil.getConnection();
			
		try {
			String sql = "select * from users where userid = ? and userpasswd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDTO.getUserid());
			pstmt.setString(2, userDTO.getUserpasswd());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return userDTO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return null;
	}


	
	}

	


