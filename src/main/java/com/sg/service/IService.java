package com.sg.service;

import java.util.List;

import com.sg.model.Student;

public interface IService {
	Student saveStudent(Student stud);
	List<Student> getAllStudents();
	Student getStudent(int id);
}
