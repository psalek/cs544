package edu.mum.cs.cs544.attendance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.CourseOfferingDAO;
import edu.mum.cs.cs544.attendance.entity.CourseOffering;

@Transactional
@Repository
public class CourseOfferingDAOImpl extends BaseDAOImpl<CourseOffering> implements CourseOfferingDAO{

	public List<CourseOffering> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
