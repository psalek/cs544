package edu.mum.cs.cs544.attendance.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.CourseDAO;
import edu.mum.cs.cs544.attendance.entity.Course;

@Transactional
@Repository
public class CourseDAOImpl extends BaseDAOImpl<Course> implements CourseDAO {

	@SuppressWarnings("unchecked")
	public List<Course> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT c from Course c");
		return new ArrayList<Course>(query.list());
		
	}

	

}
