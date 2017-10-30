package edu.mum.cs.cs544.timesheet.dao;

import java.util.List;

import edu.mum.cs.cs544.timesheet.entity.Course;

public interface CourseDAO extends BaseDAO<Course>{
	
	List<Course> getAll();
}
