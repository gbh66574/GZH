package com.entor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.PublicNumberTemplateDao;
import com.entor.entity.PublicNumberTemplate;
import com.entor.service.PublicNumberTemplateService;
import com.entor.vo.PublicNumberTemplateVo;

@Service("publicNumberTemplateService")
public class PublicNumberTemplateServiceimpl extends BaseServiceimpl<PublicNumberTemplate> implements PublicNumberTemplateService {
	@Resource
	private PublicNumberTemplateDao publicNumberTemplateDao;
	@Override
	public List<PublicNumberTemplateVo> aqueryByPage(int currntPage, int pageSize) {
		Map<String, Integer>map=new HashMap<String,Integer>();
		map.put("start", currntPage*pageSize);
		map.put("b", (currntPage-1)*pageSize);
		return publicNumberTemplateDao.aqueryByPage(map);
	}

}
