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
	
	
	public int memberJoin(MemberVO vo) {
		int result = 0;
		
		try {
			String sql = "INSERT INTO ANIMAL_MEMBER" + 
						 "(EMAIL, NAME, NICK_NAME, PASSWORD, PHONE, ADDR) " +
						 "VALUES(?, ?, ?, ?, ?, ?)";
			
			conn = DBCP.getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, vo.getEmail());
			preStatement.setString(2, vo.getName());
			preStatement.setString(3, vo.getNickName());
			preStatement.setString(4, vo.getPassword());
			preStatement.setString(5, vo.getPhone());
			preStatement.setString(6, vo.getAddr());
			
			result = preStatement.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("MemberDAO - memberInsert() 에러 : " + e.getMessage());
			
		} finally {
			DBCP.close(conn, preStatement);
		}
		return result;
	}
	
	
	public MemberVO memberLogIn(String nickName, String password) {
		MemberVO result = null;
		
		try {
			String sql = "SELECT * FROM ANIMAL_MEMBER WHERE NICK_NAME=? AND PASSWORD=?";
			conn = DBCP.getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, nickName);
			preStatement.setString(2, password);
			resultSet = preStatement.executeQuery();
			
			if(resultSet.next()) {
				result = new MemberVO();
				result.setNickName(resultSet.getString("NICK_NAME"));
			}
			
		} catch(SQLException e) {
			System.out.println("MemberDAO - memberSelect() 에러 : " + e.getMessage());
			
		} finally {
			DBCP.close(conn, preStatement, resultSet);
		}
		
		return result;
	}
	
	
	public int memberLeave(String memberLogIn, String password) {
		int result = 0;
		
		try {
			String sql = "DELETE FROM ANIMAL_MEMBER WHERE NICK_NAME=? AND PASSWORD=?";
			conn = DBCP.getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, memberLogIn);
			preStatement.setString(2, password);
			
			result = preStatement.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("MemberDAO - memberDelete() 에러 : " + e.getMessage());
			
		} finally {
			DBCP.close(conn, preStatement);
		}
		
		return result;
	}

	
	//2019.12.01 박보금 추가
	public int checkEdu(String nick_name) {
		int result = 0;
		String eduResult;
		try {
			String sql = "SELECT edu_state FROM ANIMAL_MEMBER WHERE NICK_NAME=?";
			conn = DBCP.getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, nick_name);
			resultSet = preStatement.executeQuery();
			
			if(resultSet.next()) {
				eduResult = resultSet.getString(1);
				if(eduResult.equals("YES")) {
					result = 1;
				}
			}
		} catch(SQLException e) {
			System.out.println("MemberDAO - checkEdu() 에러 : " + e.getMessage());
			
		} finally {
			DBCP.close(conn, preStatement, resultSet);
		}
		
		return result;
	}
	
	//2019.12.01 박보금 추가
	public String getPhone(String nick_name) {
		String result = null;
		try {
			String sql = "SELECT phone FROM ANIMAL_MEMBER WHERE NICK_NAME=?";
			conn = DBCP.getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, nick_name);
			resultSet = preStatement.executeQuery();
			
			if(resultSet.next()) {
				result = resultSet.getString(1);
			}
		} catch(SQLException e) {
			System.out.println("MemberDAO - checkEdu() 에러 : " + e.getMessage());
			
		} finally {
			DBCP.close(conn, preStatement, resultSet);
		}
		return result;
	}
	
}
