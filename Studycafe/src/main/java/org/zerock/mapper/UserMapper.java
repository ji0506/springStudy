package org.zerock.mapper;

import org.zerock.domain.User;

public interface UserMapper {

	
	User selectUserLogin(String userId);
	
}
