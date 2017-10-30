package edu.mum.cs.cs544.attendance.dao;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.CourseOffering;

public interface CourseOfferingDAO extends BaseDAO<CourseOffering>{

	public List<CourseOffering> getAll();
}
