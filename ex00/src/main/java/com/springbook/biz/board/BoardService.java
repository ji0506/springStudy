package com.springbook.biz.board;

import java.util.List;

public interface BoardService {

	public void update(BoardVO vo);

	public void delete(BoardVO vo);

	public BoardVO getBoard(int seq);
	
	public List<BoardVO> getBoardList();

	public void insert(BoardVO vo);
}
