package com.krt.dairy.core.auth.service;

import com.krt.dairy.common.page.TailPage;
import com.krt.dairy.core.auth.domain.AuthUser;

import java.util.List;


public interface IAuthUserService {
	
	/**
	*根据username获取
	**/
	public AuthUser getByUsername(String username);
	
	/**
	*创建
	**/
	public void createSelectivity(AuthUser entity);
	
	
	
	/**
	*根据id获取
	**/
	public AuthUser getById(Long id);
	
	/**
	*根据username和password获取
	**/
	public AuthUser getByUsernameAndPassword(AuthUser authUser);

	/**
	*获取首页推荐5个讲师
	**/
	public List<AuthUser> queryRecomd();

	/**
	*分页获取
	**/
	public TailPage<AuthUser> queryPage(AuthUser queryEntity, TailPage<AuthUser> page);

	/**
	*根据id更新
	**/
	public void update(AuthUser entity);

	/**
	*根据id 进行可选性更新
	**/
	public void updateSelectivity(AuthUser entity);

	/**
	*物理删除
	**/
	public void delete(AuthUser entity);

	/**
	*逻辑删除
	**/
	public void deleteLogic(AuthUser entity);



}

