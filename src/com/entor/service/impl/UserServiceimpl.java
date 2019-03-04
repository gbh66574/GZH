package com.entor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.UserDao;
import com.entor.entity.User;
import com.entor.service.UserService;

@Service("userService")
public class UserServiceimpl extends BaseServiceimpl<User> implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public List<User> queryAllRolesByUids(String uids) {
		
		return userDao.queryAllRolesByUids(uids);
	}

	@Override
	public List<User> deleteUserRolesByUids(String uids) {
		
		return userDao.deleteUserRolesByUids(uids);
	}

	

}
