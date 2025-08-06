package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
	private String studentid;
	private String name;
	private String major;
	private int grade;
	
	public Student() {
		System.out.println("기본생성자 호출됨");
	}
	
	public Student(String studentid, String name, String major, int grade) throws InvalidGradeException {
		setStudentid(studentid);
	    setName(name);
	    setMajor(major);
	    setGrade(grade);
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) throws InvalidGradeException {
		if(grade < 1 || grade > 4) {
			throw new InvalidGradeException("학년은 1~4 사이여야 합니다.");
		}
		this.grade = grade;
	}
	
	public void displayInfo() {
        System.out.println(name + " / " + major + " / " + grade + "학년");
    }
}
