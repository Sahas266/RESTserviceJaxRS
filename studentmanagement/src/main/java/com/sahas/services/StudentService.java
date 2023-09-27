package com.sahas.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentService {
	public List<Student> students;
	public StudentDao studentDao = new StudentDao();

	public StudentService() {
		System.out.println("callilng StudentService constructor");
		students = studentDao.readStudentList();
//		students = new ArrayList<Student>();
//		students.add(new Student(1, "stu1F", "stu1L", "middle"));
//		students.add(new Student(2, "stu2F", "stu2L", "middle"));
//		students.add(new Student(3, "stu3F", "stu3L", "middle"));
//		students.add(new Student(4, "stu4F", "stu4L", "middle"));
//		students.add(new Student(5, "stu5F", "stu5L", "middle"));
	}

	public List<Student> getStudents() {
		return students;
	}

	public String getStudentsAsJsonString() {
		System.out.println("calling getStudentsAsJsonString");
		ObjectMapper mapper = new ObjectMapper();
		String json = new String();
		try {
			json = mapper.writeValueAsString(students);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	public String getStudentAsJsonString(int id) {
		System.out.println("calling getStudentAsJsonString");
		ObjectMapper mapper = new ObjectMapper();
		String json = new String();
		try {

			for (Student student : students) {
				if (student.getId() == id) {
					json = mapper.writeValueAsString(student);
				}
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	
	// return studentService.deleteStudent(id);

	public String deleteStudent(int id) {
		System.out.println("calling deleteStudent");
		ObjectMapper mapper = new ObjectMapper();
		String json = new String();
		try {
			Iterator<Student> iterator = students.iterator();
			while (iterator.hasNext()) {
				Student student = iterator.next();
				if (student.getId() == id) {
					iterator.remove();
					json = mapper.writeValueAsString(student);
				}
			}
			studentDao.updateStudentList(students);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}	
	
	//    	return studentService.updateStudent(id, grade);

	public String updateStudent(int id, String grade) {
		System.out.println("calling deleteStudent");
		ObjectMapper mapper = new ObjectMapper();
		String json = new String();
		try {
			Iterator<Student> iterator = students.iterator();
			while (iterator.hasNext()) {
				Student student = iterator.next();
				if (student.getId() == id) {
					student.setGrade(grade);
					json = mapper.writeValueAsString(student);
				}
			}
			studentDao.updateStudentList(students);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}	
	
	//  	return studentService.createStudent(id, firstName, lastName, grade);

	public String addStudent(int id, String firstName, String lastName, String grade) {
		System.out.println("addStudent");
		Student student = new Student(id, firstName, lastName, grade);
		students.add(student);
		ObjectMapper mapper = new ObjectMapper();
		String json = new String();	
		try {
			json = mapper.writeValueAsString(student);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		studentDao.updateStudentList(students);
		return json;
	}	
	

	// return studentService.getStudentAsJsonString(studentID);

	public static void main(String[] args) throws JsonProcessingException {
		StudentService service = new StudentService();
		System.out.println(service.getStudentsAsJsonString());
		service.addStudent(6, "stu6F",  "stu6L", "high");
		System.out.println(service.getStudentsAsJsonString());
	}
}
