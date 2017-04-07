package com.imooc.service.impl;

import com.imooc.dao.UserDao;
import com.imooc.dao.impl.UserDaoImpl;
import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.utils.MailUtils;

public class UserServiceImpl implements UserService {

	@Override
	public void regist(User user) throws Exception {
		//将数据存到数据库
		UserDao userDao = new UserDaoImpl();
		
		userDao.regist(user);
		//发送一封激活的邮件
		MailUtils.SendMail(user.getEmail(), user.getCode());
	}

	/**
	 * 根据激活码查询用户
	 */
	@Override
	public User findUserByCode(String code) throws Exception {
		UserDao userDao = new UserDaoImpl();
		return userDao.findUserByCode(code);
	}

	@Override
	public void update(User user) throws Exception {
		UserDao userDao = new UserDaoImpl();
		userDao.update(user);
	}

}
