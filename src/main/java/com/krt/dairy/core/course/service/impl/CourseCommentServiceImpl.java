package com.krt.dairy.core.course.service.impl;

import com.krt.dairy.common.page.TailPage;
import com.krt.dairy.core.course.dao.CourseCommentDao;
import com.krt.dairy.core.course.domain.CourseComment;
import com.krt.dairy.core.course.service.ICourseCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseCommentServiceImpl implements ICourseCommentService{

	@Autowired
	private CourseCommentDao entityDao;

	@Override
	public CourseComment getById(Long id){
		return entityDao.getById(id);
	}

	@Override
	public List<CourseComment> queryAll(CourseComment queryEntity){
		return entityDao.queryAll(queryEntity);
	}

	@Override
	public TailPage<CourseComment> queryPage(CourseComment queryEntity ,TailPage<CourseComment> page){
		Integer itemsTotalCount = entityDao.getTotalItemsCount(queryEntity);
		List<CourseComment> items = entityDao.queryPage(queryEntity,page);
		page.setItemsTotalCount(itemsTotalCount);
		page.setItems(items);
		return page;
	}
	
	@Override
	public TailPage<CourseComment> queryMyQAItemsPage(CourseComment queryEntity ,TailPage<CourseComment> page){
		Integer itemsTotalCount = entityDao.getMyQAItemsCount(queryEntity);
		List<CourseComment> items = entityDao.queryMyQAItemsPage(queryEntity,page);
		page.setItemsTotalCount(itemsTotalCount);
		page.setItems(items);
		return page;
	}

	@Override
	public void create(CourseComment entity){
		entityDao.create(entity);
	}
	
	/**
	 * 创建
	 */
	public void createSelectivity(CourseComment entity){
		entityDao.createSelectivity(entity);
	}

	@Override
	public void update(CourseComment entity){
		entityDao.update(entity);
	}

	@Override
	public void updateSelectivity(CourseComment entity){
		entityDao.updateSelectivity(entity);
	}

	@Override
	public void delete(CourseComment entity){
		entityDao.delete(entity);
	}

	@Override
	public void deleteLogic(CourseComment entity){
		entityDao.deleteLogic(entity);
	}



}

