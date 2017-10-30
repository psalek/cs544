package cs544.exercise16_2;

public class StudentService {
	private StudentDAO studentdao;

	public StudentService() {
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {
		return studentdao.load(studentid);
	}
}
