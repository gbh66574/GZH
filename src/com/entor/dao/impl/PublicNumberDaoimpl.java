package com.entor.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entor.dao.PublicNumberDao;
import com.entor.entity.PublicNumber;
import com.entor.entity.User;
@Repository("publicNumberDao")
public class PublicNumberDaoimpl extends BaseDaoimpl<PublicNumber>   implements PublicNumberDao {

	@Override
	public List<PublicNumber> queryAllRolesByUids(String uids) {
		return getSqlSession().selectList(PublicNumber.class.getSimpleName()+"queryAllRolesByUids");

	}

}
