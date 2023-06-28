package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		BoardService boardService = (BoardService) factory.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용......");
		boardService.insert(vo);
		
		List<BoardVO> list = boardService.getBoardList();
		for(BoardVO vo2 : list)
		{
			System.out.println("---->" + vo2.toString());
		}
		
		factory.close();
	}

}
