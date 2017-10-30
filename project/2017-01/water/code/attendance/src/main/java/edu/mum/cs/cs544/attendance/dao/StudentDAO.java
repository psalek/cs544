package edu.mum.cs.cs544.attendance.dao;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.Student;

public interface StudentDAO extends BaseDAO<Student>{
	
	public List<Student> getAll();

}
