package com.entor.dao;

import java.util.List;
import java.util.Map;

import com.entor.entity.PublicNumberTemplate;
import com.entor.vo.PublicNumberTemplateVo;

public interface PublicNumberTemplateDao extends BaseDao<PublicNumberTemplate> {
	public List<PublicNumberTemplateVo> aqueryByPage(Map<String, Integer>map);
}
