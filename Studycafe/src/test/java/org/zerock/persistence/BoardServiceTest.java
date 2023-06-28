package org.zerock.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.UserMapper;
import org.zerock.service.BoardService;
import org.zerock.service.UserService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {

	@Autowired
	private UserService service;

	@Autowired
	private UserMapper map;

	
//	@Test
//	public void textExist() {
//		
//		log.info(service);
//		assertNotNull(service);
//	}
//	
//	@Test
//	public void textRegister() {
//		
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글");
//		board.setContent("신 내용");
//		board.setWriter("Newbie");
//		
//		service.register(board);
//		
//		log.info("생성된 게시물의 번호" + board.getBno());
//	}
//	
//	@Test
//	public void testGetList() {
//		service.getList().forEach(board -> log.info(board));
//	}
	
//	@Test
//	public void testGet() {
//		log.info(service.get(1L));
//	}
	
	@Test
	public void testDelete() {
		log.info( map.selectUserLogin("admin"));
	}
	

}

