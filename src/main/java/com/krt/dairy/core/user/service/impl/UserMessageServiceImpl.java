package com.krt.dairy.core.user.service.impl;

import com.krt.dairy.common.page.TailPage;
import com.krt.dairy.core.user.dao.UserMessageDao;
import com.krt.dairy.core.user.domain.UserMessage;
import com.krt.dairy.core.user.service.IUserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserMessageServiceImpl implements IUserMessageService{

	@Autowired
	private UserMessageDao entityDao;

	public UserMessage getById(Long id){
		return entityDao.getById(id);
	}

	public List<UserMessage> queryAll(UserMessage queryEntity){
		return entityDao.queryAll(queryEntity);
	}

	public TailPage<UserMessage> queryPage(UserMessage queryEntity ,TailPage<UserMessage> page){
		Integer itemsTotalCount = entityDao.getTotalItemsCount(queryEntity);
		List<UserMessage> items = entityDao.queryPage(queryEntity,page);
		page.setItemsTotalCount(itemsTotalCount);
		page.setItems(items);
		return page;
	}

	public void create(UserMessage entity){
		entityDao.create(entity);
	}

	public void update(UserMessage entity){
		entityDao.update(entity);
	}

	public void updateSelectivity(UserMessage entity){
		entityDao.updateSelectivity(entity);
	}

	public void delete(UserMessage entity){
		entityDao.delete(entity);
	}

	public void deleteLogic(UserMessage entity){
		entityDao.deleteLogic(entity);
	}



}

