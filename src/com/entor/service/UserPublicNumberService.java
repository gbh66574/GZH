package com.entor.service;

import java.util.List;
import java.util.Map;

import com.entor.entity.UserPublicNumber;
import com.entor.vo.UserPublicNumberVo;

public interface UserPublicNumberService extends BaseService<UserPublicNumber> {
	public List<UserPublicNumberVo> aqueryByPage(int currntPage,int pageSize);
	public void deleteUserRolesByUids(String uids);

}
