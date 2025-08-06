package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {

	public static void main(String[] args) {
        // Student 생성자나 setGrade가 예외를 던질 수 있으므로 try-catch로 감싸야 합니다.
        try {
            Student student1 = new Student("S001", "김민수", "컴퓨터공학", 3);
            student1.displayInfo();
            
            System.out.println("5학년으로 변경");
            student1.setGrade(5);

        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
        }
	}

}
