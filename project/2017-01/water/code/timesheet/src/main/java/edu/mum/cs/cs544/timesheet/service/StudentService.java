package edu.mum.cs.cs544.timesheet.service;

import java.util.List;

import edu.mum.cs.cs544.timesheet.entity.Student;

public interface StudentService {
	
	public Student addStudent(Student student);

	public Student updateStudent(Student student);

	public boolean deleteStudentById(int id);

	public Student getStudentById(int id);

	public List<Student> getAllStudents();

	public boolean saveAll(List<Student> students);


}
