package com.krt.dairy.core.consts.service.impl;

import com.krt.dairy.common.page.TailPage;
import com.krt.dairy.common.storage.QiniuStorage;
import com.krt.dairy.core.consts.dao.ConstsSiteCarouselDao;
import com.krt.dairy.core.consts.domain.ConstsSiteCarousel;
import com.krt.dairy.core.consts.service.IConstsSiteCarouselService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConstsSiteCarouselServiceImpl implements IConstsSiteCarouselService{

	@Autowired
	private ConstsSiteCarouselDao entityDao;

	@Override
	public ConstsSiteCarousel getById(Long id){
		return entityDao.getById(id);
	}

	@Override
	public List<ConstsSiteCarousel> queryCarousels(Integer count){
		List<ConstsSiteCarousel> resultList = entityDao.queryCarousels(count);
		//处理为七牛图片链接
		for(ConstsSiteCarousel item : resultList){
			item.setPicture(QiniuStorage.getUrl(item.getPicture()));
		}
		return resultList;
	}

	@Override
	public TailPage<ConstsSiteCarousel> queryPage(ConstsSiteCarousel queryEntity ,TailPage<ConstsSiteCarousel> page){
		Integer itemsTotalCount = entityDao.getTotalItemsCount(queryEntity);
		List<ConstsSiteCarousel> items = entityDao.queryPage(queryEntity,page);
		if(CollectionUtils.isNotEmpty(items)){
			for(ConstsSiteCarousel item : items){
				String pictureUrl = QiniuStorage.getUrl(item.getPicture());//处理图片
				item.setPicture(pictureUrl);
			}
		}
		page.setItemsTotalCount(itemsTotalCount);
		page.setItems(items);
		return page;
	}

	@Override
	public void create(ConstsSiteCarousel entity){
		entityDao.create(entity);
	}
	
	/**
	 * 创建新记录
	 */
	public void createSelectivity(ConstsSiteCarousel entity){
		this.entityDao.createSelectivity(entity);
	}

	@Override
	public void update(ConstsSiteCarousel entity){
		entityDao.update(entity);
	}

	@Override
	public void updateSelectivity(ConstsSiteCarousel entity){
		entityDao.updateSelectivity(entity);
	}

	@Override
	public void delete(ConstsSiteCarousel entity){
		entityDao.delete(entity);
	}

	@Override
	public void deleteLogic(ConstsSiteCarousel entity){
		entityDao.deleteLogic(entity);
	}



}

