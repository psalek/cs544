package edu.mum.cs.cs544.timesheet.service;

import java.util.List;

import edu.mum.cs.cs544.timesheet.entity.Course;

public interface CourseService {

	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public boolean deleteCourseById(int id);

	public Course getCourseById(int id);

	public List<Course> getAllCourses();

	public boolean saveAll(List<Course> courses);

}
