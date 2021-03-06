package com.test.app.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.test.app.common.JDBCUtil;
import com.test.app.member.MemberVO;

@Repository("memberDAO")
public class MemberDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String member_selectOne = "select * from member where mid=? and password =?";

	public MemberVO selectOne(MemberVO vo) {
		MemberVO data = null;
		conn = JDBCUtil.connect();
		try {
			data = new MemberVO();

			pstmt = conn.prepareStatement(member_selectOne);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				data.setMid(rs.getString("mid"));
				data.setPassword(rs.getString("password"));
				data.setMname(rs.getString("mname"));
				data.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO selectOne()에서 문제발생!");
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}

}