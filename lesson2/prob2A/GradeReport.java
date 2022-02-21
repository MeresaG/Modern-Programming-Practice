package lesson2.prob2A;

public class GradeReport {

	private Student student;

	public GradeReport(Student s) {
		
		this.student = s;
		
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void print() {
		System.out.println("Grade report object!");
	}

}
