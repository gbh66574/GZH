package com.entor.dao;

import java.util.List;

import com.entor.entity.PublicNumber;
import com.entor.entity.User;
import com.entor.entity.UserPublicNumber;

public interface UserDao extends BaseDao<User> {
	public List<User> queryAllRolesByUids(String uids);
	public  List<User> deleteUserRolesByUids(String uids);
}
