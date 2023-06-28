package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Board;

public interface BoardMapper {

	public List<Board>selectBoardList(Board vo);
}
