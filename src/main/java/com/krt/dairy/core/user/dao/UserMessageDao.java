package com.krt.dairy.core.user.dao;

import com.krt.dairy.common.page.TailPage;
import com.krt.dairy.core.user.domain.UserMessage;

import java.util.List;


public interface UserMessageDao {

	/**
	*根据id获取
	**/
	public UserMessage getById(Long id);

	/**
	*获取所有
	**/
	public List<UserMessage> queryAll(UserMessage queryEntity);

	/**
	*获取总数量
	**/
	public Integer getTotalItemsCount(UserMessage queryEntity);

	/**
	*分页获取
	**/
	public List<UserMessage> queryPage(UserMessage queryEntity, TailPage<UserMessage> page);

	/**
	*创建新记录
	**/
	public void create(UserMessage entity);

	/**
	*根据id更新
	**/
	public void update(UserMessage entity);

	/**
	*根据id选择性更新自动
	**/
	public void updateSelectivity(UserMessage entity);

	/**
	*物理删除
	**/
	public void delete(UserMessage entity);

	/**
	*逻辑删除
	**/
	public void deleteLogic(UserMessage entity);



}

