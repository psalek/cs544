package edu.mum.cs.cs544.timesheet.dao;

import java.util.List;

import edu.mum.cs.cs544.timesheet.entity.Student;

public interface StudentDAO extends BaseDAO<Student>{
	
	public List<Student> getAll();

}
