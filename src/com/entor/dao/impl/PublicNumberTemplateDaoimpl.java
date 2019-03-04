package com.entor.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.PublicNumberTemplateDao;
import com.entor.entity.PublicNumberTemplate;
import com.entor.vo.PublicNumberTemplateVo;
@Repository("publicNumberTemplateDao")
public class PublicNumberTemplateDaoimpl extends BaseDaoimpl<PublicNumberTemplate> implements PublicNumberTemplateDao {

	@Override
	public List<PublicNumberTemplateVo> aqueryByPage(Map<String, Integer> map) {
		
		return getSqlSession().selectList(PublicNumberTemplate.class.getSimpleName()+".queryByPage", map);
	}

}
