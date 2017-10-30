package edu.mum.cs.cs544.attendance.dao;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.Course;

public interface CourseDAO extends BaseDAO<Course>{
	
	List<Course> getAll();
}
