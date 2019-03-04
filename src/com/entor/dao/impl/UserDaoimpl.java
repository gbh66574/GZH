package com.entor.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entor.dao.UserDao;
import com.entor.entity.PublicNumber;
import com.entor.entity.User;
@Repository("userDao")
public class UserDaoimpl extends BaseDaoimpl<User> implements UserDao {

	@Override
	public List<User> queryAllRolesByUids(String uids) {
		
		return getSqlSession().selectList(User.class.getSimpleName()+".queryAllRolesByUids",uids );
	}

	@Override
	public List<User> deleteUserRolesByUids(String uids) {
		return getSqlSession().selectList(User.class.getSimpleName()+".deleteUserRolesByUids",uids );

	}

	

	
}
