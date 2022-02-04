package com.test.app.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.board.BoardService;
import com.test.app.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		System.out.println("BoardServiceIpml 에서 insertBoard() 진입");
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		System.out.println("BoardServiceIpml 에서 updateBoard() 진입");
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		System.out.println("BoardServiceIpml 에서 deleteBoard() 진입");
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		System.out.println("BoardServiceIpml 에서 selectOne() 진입");
		return boardDAO.selectOne(vo);
		
	}

	@Override
	public List<BoardVO> selectAll() {
		System.out.println("BoardServiceIpml 에서 selectAll 진입");
		return boardDAO.selectAll();
	}

}
