package com.entor.dao;

import java.util.List;

import com.entor.entity.PublicNumber;
import com.entor.entity.User;

public interface PublicNumberDao extends BaseDao<PublicNumber>{
	public List<PublicNumber> queryAllRolesByUids(String uids);
}
