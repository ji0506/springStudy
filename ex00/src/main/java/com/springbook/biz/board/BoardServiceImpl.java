package com.springbook.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO dao;
	
	@Override
	public void update(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.delete(vo);
		
	}

	@Override
	public BoardVO getBoard(int seq) {
		// TODO Auto-generated method stub
		
		return dao.getBoard(seq);
	}

	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		System.out.println("jdbc getBoardList");
		return dao.getBoardList();
	}

	@Override
	public void insert(BoardVO vo) {
		// TODO Auto-generated method stub
		
		System.out.println("jdbc insert");

		dao.insert(vo);
	}

}
