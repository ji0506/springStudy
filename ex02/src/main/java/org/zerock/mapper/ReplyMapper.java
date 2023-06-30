package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {

//	@Select("select * from tbl_board where bno >0 order by bno desc")
	public List<BoardVO> getList();

	public int getTotalCount(Criteria cri);

	public List<ReplyVO> getListwithPage(@Param("cri") Criteria cri, @Param("bno") Long bno);

	public int insert(ReplyVO reply);
	
	public void insertSelectKey(ReplyVO reply);
	
	public ReplyVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(ReplyVO reply);
}
