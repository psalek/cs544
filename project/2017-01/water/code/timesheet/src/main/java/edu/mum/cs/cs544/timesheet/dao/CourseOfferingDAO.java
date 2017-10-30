package edu.mum.cs.cs544.timesheet.dao;

import java.util.List;

import edu.mum.cs.cs544.timesheet.entity.CourseOffering;

public interface CourseOfferingDAO extends BaseDAO<CourseOffering>{

	public List<CourseOffering> getAll();
}
