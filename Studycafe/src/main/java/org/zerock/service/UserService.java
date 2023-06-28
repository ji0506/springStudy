package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.User;
import org.zerock.mapper.UserMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class UserService {
	
	@Autowired
	private UserMapper mapper;


	public User getLoginUser(String id) {
	
		return mapper.selectUserLogin(id);
	}
	

	

}
