package com.test.app.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.app.board.BoardVO;
import com.test.app.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String board_insert = "insert into board4(title,writer,content) values(?,?,?)";
	private String board_update = "update board4 set title=?, content=? where bid=?";
	private String board_delete = "delete from board4 where bid=?";
	private String board_selectOne = "select * from board4 where bid=?";
	private String board_selectAll = "select * from board4 order by bid desc";

	public void insertBoard(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(board_insert);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoardDAO insertBoard()에서 문제발생!");
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	public void updateBoard(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(board_update);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoardDAO updateBoard()에서 문제발생!");
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	public void deleteBoard(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(board_delete);
			pstmt.setInt(1, vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoardDAO deleteBoard()에서 문제발생!");
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	public BoardVO selectOne(BoardVO vo) {
		BoardVO data = null;
		conn = JDBCUtil.connect();

		try {
			data = new BoardVO();

			pstmt = conn.prepareStatement(board_selectOne);
			pstmt.setInt(1, vo.getBid());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				data.setBid(rs.getInt("bid"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setWriter(rs.getString("writer"));
				data.setBdate(rs.getDate("bdate"));
				data.setCnt(rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoardDAO selectOne()에서 문제발생!");
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}

	public List<BoardVO> selectAll() {
		List<BoardVO> datas = null;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(board_selectAll);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBid(rs.getInt("bid"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setBdate(rs.getDate("bdate"));
				vo.setCnt(rs.getInt("cnt"));
				datas.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoardDAO selectAll()에서 문제발생!");
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}

}