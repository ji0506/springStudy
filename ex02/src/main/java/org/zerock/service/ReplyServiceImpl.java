package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO reply) {
		// TODO Auto-generated method stub
		log.info("register......" + reply);
		return mapper.insert(reply);
	}

	@Override
	public ReplyVO get(Long bno) {
		log.info("get......" + bno);
		return mapper.read(bno);
	}

	@Override
	public int modify(ReplyVO reply) {
		log.info("modify......" + reply);
		return mapper.update(reply);
	}

	@Override
	public int remove(Long bno) {
		log.info("remove......" + bno);
		return mapper.delete(bno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		
		log.info("getList........");
		
 		return mapper.getListwithPage(cri, bno);
	}
	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}

}
