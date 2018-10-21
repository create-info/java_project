package com.krt.dairy.portal.business.impl;

import com.krt.dairy.core.consts.CourseEnum;
import com.krt.dairy.core.course.domain.CourseSection;
import com.krt.dairy.core.course.service.ICourseSectionService;
import com.krt.dairy.portal.business.ICourseBusiness;
import com.krt.dairy.portal.vo.CourseSectionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * 课程业务层
 */
@Service
public class CourseBusinessImpl implements ICourseBusiness {
	
	@Autowired
	private ICourseSectionService courseSectionService;
	
	/**
	 * 获取课程章节
	 */
	public List<CourseSectionVO> queryCourseSection(Long courseId){
		List<CourseSectionVO> resultList = new ArrayList<CourseSectionVO>();
		CourseSection queryEntity = new CourseSection();
		queryEntity.setCourseId(courseId);
		queryEntity.setOnsale(CourseEnum.ONSALE.value());//上架
		
		Map<Long,CourseSectionVO> tmpMap = new LinkedHashMap<Long,CourseSectionVO>();
		Iterator<CourseSection> it = courseSectionService.queryAll(queryEntity).iterator();
		while(it.hasNext()){
			CourseSection item = it.next();
			if(Long.valueOf(0).equals(item.getParentId())){//章
				CourseSectionVO vo = new CourseSectionVO();
				BeanUtils.copyProperties(item, vo);
				tmpMap.put(vo.getId(), vo);
			}else{
				tmpMap.get(item.getParentId()).getSections().add(item);//小节添加到大章中
			}
		}
		for(CourseSectionVO vo : tmpMap.values()){
			resultList.add(vo);
		}
		return resultList;
	}
	
}
