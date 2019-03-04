package com.entor.service;

import java.util.List;

import com.entor.entity.User;

public interface UserService extends BaseService<User> {
	public List<User> queryAllRolesByUids(String uids);
	public  List<User> deleteUserRolesByUids(String uids);

}
