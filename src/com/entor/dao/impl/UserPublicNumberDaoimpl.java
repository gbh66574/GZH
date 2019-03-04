package com.entor.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.UserPublicNumberDao;
import com.entor.entity.UserPublicNumber;
import com.entor.vo.UserPublicNumberVo;
@Repository("userPublicNumberDao")
public class UserPublicNumberDaoimpl extends BaseDaoimpl<UserPublicNumber> implements UserPublicNumberDao {

	@Override
	public List<UserPublicNumberVo> aqueryByPage(Map<String, Integer>map) {
		
		return getSqlSession().selectList(UserPublicNumber.class.getSimpleName()+".queryByPage",map);
	}

	@Override
	public void deleteUserRolesByUids(String uids) {
		
		getSqlSession().delete(UserPublicNumber.class.getSimpleName()+".deleteUserRolesByUids", uids);
		
	}

	

	
}
