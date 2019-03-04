package com.entor.service;

import java.util.List;

import com.entor.entity.PublicNumber;
import com.entor.entity.User;

public interface PublicNumberService extends BaseService<PublicNumber> {
	public List<PublicNumber> queryAllRolesByUids(String uids);
}
