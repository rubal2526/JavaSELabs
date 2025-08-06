package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {

	public static void main(String[] args) {
        // Student �����ڳ� setGrade�� ���ܸ� ���� �� �����Ƿ� try-catch�� ���ξ� �մϴ�.
        try {
            Student student1 = new Student("S001", "��μ�", "��ǻ�Ͱ���", 3);
            student1.displayInfo();
            
            System.out.println("5�г����� ����");
            student1.setGrade(5);

        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
        }
	}

}
