package com.entor.service;

import java.util.List;

import com.entor.entity.PublicNumberTemplate;
import com.entor.vo.PublicNumberTemplateVo;


public interface PublicNumberTemplateService extends BaseService<PublicNumberTemplate> {
	public List<PublicNumberTemplateVo> aqueryByPage(int currntPage,int pageSize);
	}

