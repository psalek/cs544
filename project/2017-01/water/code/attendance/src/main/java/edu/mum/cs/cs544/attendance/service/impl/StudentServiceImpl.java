package edu.mum.cs.cs544.attendance.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.entity.Student;
import edu.mum.cs.cs544.attendance.service.StudentService;

@Transactional
@Service
public class StudentServiceImpl implements StudentService{

	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteStudentById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean saveAll(List<Student> students) {
		// TODO Auto-generated method stub
		return false;
	}

}
