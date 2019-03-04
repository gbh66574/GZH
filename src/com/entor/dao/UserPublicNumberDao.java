package com.entor.dao;

import java.util.List;
import java.util.Map;

import com.entor.entity.UserPublicNumber;
import com.entor.vo.UserPublicNumberVo;

public interface UserPublicNumberDao extends BaseDao<UserPublicNumber> {
	public List<UserPublicNumberVo> aqueryByPage(Map<String, Integer>map);
	public  void  deleteUserRolesByUids(String uids);
	
}
