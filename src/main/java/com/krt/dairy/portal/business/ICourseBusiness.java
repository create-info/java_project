package com.krt.dairy.portal.business;

import com.krt.dairy.portal.vo.CourseSectionVO;

import java.util.List;

public interface ICourseBusiness {

	/**
	 * 获取课程章节
	 */
	List<CourseSectionVO> queryCourseSection(Long courseId);
	
}
