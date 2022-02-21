package lesson2.prob2A;

public class Main {

	public static void main(String[] args) {
		
		String name = "Meresa";
		
		Student student=  new Student(name);
		
		GradeReport gradeReport = student.getGradeReport();
		
		
		gradeReport.print();
		student.print();
		

	}

}
