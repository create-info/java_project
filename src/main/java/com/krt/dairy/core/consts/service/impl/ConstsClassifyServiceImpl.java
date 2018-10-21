package com.krt.dairy.core.consts.service.impl;

import com.krt.dairy.common.page.TailPage;
import com.krt.dairy.core.consts.dao.ConstsClassifyDao;
import com.krt.dairy.core.consts.domain.ConstsClassify;
import com.krt.dairy.core.consts.service.IConstsClassifyService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConstsClassifyServiceImpl implements IConstsClassifyService{

	@Autowired
	private ConstsClassifyDao entityDao;

	public ConstsClassify getById(Long id){
		return entityDao.getById(id);
	}

	public List<ConstsClassify> queryAll(){
		return entityDao.queryAll();
	}
	
	@Override
	public List<ConstsClassify> queryByCondition(ConstsClassify queryEntity){
		return entityDao.queryByCondition(queryEntity);
	}
	
	@Override
	public ConstsClassify getByCode(String code){
		if(StringUtils.isEmpty(code))
			return null;
		ConstsClassify queryEntity = new ConstsClassify();
		queryEntity.setCode(code);
		List<ConstsClassify> list = entityDao.queryByCondition(queryEntity);
		if(CollectionUtils.isNotEmpty(list))
			return list.get(0);
		return null;
	}

	public TailPage<ConstsClassify> queryPage(ConstsClassify queryEntity ,TailPage<ConstsClassify> page){
		Integer itemsTotalCount = entityDao.getTotalItemsCount(queryEntity);
		List<ConstsClassify> items = entityDao.queryPage(queryEntity,page);
		page.setItemsTotalCount(itemsTotalCount);
		page.setItems(items);
		return page;
	}

	@Override
	public void create(ConstsClassify entity){
		entityDao.create(entity);
	}

	@Override
	public void createSelectivity(ConstsClassify entity){
		entityDao.createSelectivity(entity);
	}

	@Override
	public void updateSelectivity(ConstsClassify entity){
		entityDao.updateSelectivity(entity);
	}

	@Override
	public void delete(ConstsClassify entity){
		entityDao.delete(entity);
	}

	@Override
	public void deleteLogic(ConstsClassify entity){
		entityDao.deleteLogic(entity);
	}
	
	
}

