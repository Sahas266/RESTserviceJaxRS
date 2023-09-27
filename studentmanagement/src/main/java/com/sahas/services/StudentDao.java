package com.sahas.services;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	public static File file = new File(
			"C:\\Users\\Administrator\\Desktop\\Sahas\\proj\\studentmanagement\\src\\main\\resources\\students.dat");
	public List<Student> studentList = new ArrayList<Student>();

	public List<Student> readStudentList() {
		List<Student> studentList = new ArrayList<Student>();
		try {
			FileInputStream fis;
			fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (true) {
				try {
					Student user = (Student) ois.readObject();
					studentList.add(user);
				} catch (EOFException e) {
					// Reached the end of the file.
					break;
				}
			}
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;

	}

	private void deleteFile() {
		if (file.exists())
			file.delete();

	}

	public void updateStudentList(List<Student> studentList) {
		deleteFile();
		try {
			FileOutputStream fos;
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Student student : studentList) {
				oos.writeObject(student);
			}
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createStudentList() {
		studentList.add(new Student(1, "stu1F", "stu1L", "middle"));
		studentList.add(new Student(2, "stu2F", "stu2L", "middle"));
		studentList.add(new Student(3, "stu3F", "stu3L", "middle"));
		studentList.add(new Student(4, "stu4F", "stu4L", "middle"));
		studentList.add(new Student(5, "stu5F", "stu5L", "middle"));
		try {
			FileOutputStream fos;
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Student student : studentList) {
				oos.writeObject(student);
			}
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printStudents(List<Student> students) {
		for (Student s : students) {
			System.out.println(s.getId() + " " + s.getFirstName() + " " + s.getLastName() + " " + s.getGrade());
		}
	}
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		dao.createStudentList();
//		List<Student> students = dao.readStudentList();
//		dao.printStudents(students);
//		students.remove(2);
//		dao.updateStudentList(students);
//		students = dao.readStudentList();
//		dao.printStudents(students);
	}

}
