package com.entor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.PublicNumberDao;
import com.entor.entity.PublicNumber;
import com.entor.service.PublicNumberService;

@Service("publicNumberService")
public class PublicNumberServiceimpl extends BaseServiceimpl<PublicNumber> implements PublicNumberService {
	@Resource
	private PublicNumberDao publicNumberDao;
	@Override
	public List<PublicNumber> queryAllRolesByUids(String uids) {
		
		return publicNumberDao.queryAllRolesByUids(uids);
	}

}
