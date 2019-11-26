package com.animal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.animal.dbConnection.DBCP;
import com.animal.vo.MapVO;

public class MapDAO {
	private static final MapDAO mapDao;

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	static {
		mapDao = new MapDAO();
	}

	private MapDAO() {
	}

	public static MapDAO getInstance() {
		return mapDao;
	}

	public ArrayList<MapVO> mapSelectAll() {

		ArrayList<MapVO> list = new ArrayList<MapVO>();

		String sql = "SELECT * FROM MAP";

		try {
			conn = DBCP.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MapVO mapVO = new MapVO();
				mapVO.setMember_nickname(rs.getString("member_nickname"));
				mapVO.setX(rs.getString("x"));
				mapVO.setY(rs.getString("y"));
				mapVO.setTitle(rs.getString("title"));
				mapVO.setSpecial(rs.getString("special"));
				mapVO.setMap_address(rs.getString("map_address"));
				list.add(mapVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public String mapSelectAllJson() {

		JSONArray jsonArr = new JSONArray();

		String sql = "SELECT * FROM MAP";

		try {
			conn = DBCP.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("member_nickname",(rs.getString("member_nickname")));
				jsonObj.put("x",(rs.getString("x")));
				jsonObj.put("y",(rs.getString("y")));
				jsonObj.put("title",(rs.getString("title")));
				jsonObj.put("special",(rs.getString("special")));
				jsonObj.put("map_address",(rs.getString("map_address")));
				jsonArr.put(jsonObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		String json = jsonArr.toString();
		return json;
	}
	
	public int mapInsert(MapVO vo) {
		int result = 0;
		String sql = "INSERT INTO MAP VALUES(?,?,?,?,?,?)";
		
		try {
			conn = DBCP.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getMember_nickname());
			pstmt.setString(2, vo.getX());
			pstmt.setString(3, vo.getY());
			pstmt.setString(4, vo.getMap_address());
			pstmt.setString(5, vo.getSpecial());
			pstmt.setString(6, vo.getTitle());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
}
