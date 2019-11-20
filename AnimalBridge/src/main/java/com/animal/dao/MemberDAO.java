package com.animal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.animal.dbConnection.DBCP;
import com.animal.vo.MemberVO;

public class MemberDAO {
	private static final MemberDAO dao;
	
	private Connection conn;
	private PreparedStatement preStatement;
	private ResultSet resultSet;
	
	static {
		dao = new MemberDAO();
	}
	
	private MemberDAO() { }
	
	public static MemberDAO getInstance() {
		return dao;
	}
	
	
	public int memberInsert(MemberVO vo) {
		int result = 0;
		
		try {
			String sql = "INSERT INTO ANIMAL_MEMBER" + 
						 "(NICK_NAME, EMAIL, PASSWORD, ADDR, PHONE) " +
						 "VALUES(?, ?, ?, ?, ?)";
			
			conn = DBCP.getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, vo.getNickName());
			preStatement.setString(2, vo.getEmail());
			preStatement.setString(3, vo.getPassword());
			preStatement.setString(4, vo.getAddr());
			preStatement.setString(5, vo.getPhone());
			
			result = preStatement.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("MemberDAO - memberInsert() 에러 : " + e.getMessage());
			
		} finally {
			DBCP.close(conn, preStatement);
		}
		
		return result;
	}
	
	
	public MemberVO memberSelect(String nickName, String password) {
		MemberVO memberVO = null;
		
		try {
			String sql = "SELECT * FROM ANIMAL_MEMBER WHERE NICK_NAME=? AND PASSWORD=?";
			conn = DBCP.getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, nickName);
			preStatement.setString(2, password);
			resultSet = preStatement.executeQuery();
			
			if(resultSet.next()) {
				memberVO = new MemberVO(resultSet.getString("NICK_NAME"),
										resultSet.getString("EMAIL"),
										resultSet.getString("PASSWORD"),
										resultSet.getString("ADDR"),
										resultSet.getString("PHONE"));
			}
			
		} catch(SQLException e) {
			System.out.println("MemberDAO - memberSelect() 에러 : " + e.getMessage());
			
		} finally {
			DBCP.close(conn, preStatement, resultSet);
		}
		
		return memberVO;
	}
	
	
	public int memberDelete(String nickName) {
		int result = 0;
		
		try {
			String sql = "DELETE FROM ANIMAL_MEMBER WHERE NICK_NAME=?";
			conn = DBCP.getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, nickName);
			
			result = preStatement.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("MemberDAO - memberDelete() 에러 : " + e.getMessage());
			
		} finally {
			DBCP.close(conn, preStatement);
		}
		
		return result;
	}
	
	public void test(String test) {
		
	}
}
