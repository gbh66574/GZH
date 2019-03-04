package com.entor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.UserPublicNumberDao;
import com.entor.entity.UserPublicNumber;
import com.entor.service.UserPublicNumberService;
import com.entor.vo.UserPublicNumberVo;
@Service("userPublicNumberService")
public class UserPublicNumberServiceimpl extends BaseServiceimpl<UserPublicNumber> implements UserPublicNumberService {

	@Resource
	private UserPublicNumberDao userPublicNumberDao;

	@Override
	public List<UserPublicNumberVo> aqueryByPage(int currntPage, int pageSize) {
		Map<String, Integer>map=new HashMap<String,Integer>();
		map.put("start", currntPage*pageSize);
		map.put("b", (currntPage-1)*pageSize);
		
		return userPublicNumberDao.aqueryByPage(map);
	}

	@Override
	public void deleteUserRolesByUids(String uids) {
		userPublicNumberDao.deleteUserRolesByUids(uids);
		
	}

	

	
	
	

	

}
