package com.imooc.service;

import com.imooc.domain.User;

public interface UserService {

	void regist(User user) throws  Exception;

	User findUserByCode(String code) throws  Exception;

	void update(User user) throws  Exception;

}
