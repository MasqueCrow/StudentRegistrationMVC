package com.sg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.dao.StudentRepository;
import com.sg.model.Student;

@Service
public class StudentService implements IService {
	@Autowired
	private StudentRepository dao; 
	
	public StudentService() {
	}
	
	@Override
	public List<Student> getAllStudents() {
		return dao.findAll();
	}
	
	@Override
	public Student getStudent(int id) {
		Optional<Student> student = dao.findById(id);
		
		if(student.isPresent()) {
			return student.get();
		}
		
		return null;
	}
	
	public Student saveStudent(Student stud) {
		return dao.save(stud);
	}

	public void removeStudent(int id) {
		dao.deleteById(id);
	}
	
	public List<Student> findStudentByName(String name) {
		return dao.findByName(name);
	}

	public int updateStudent(Student stud) {
		int id = stud.getId();
		int age = stud.getAge();
		int mobile_no = stud.getMobileNo();
		String name = stud.getName();
		String addr = stud.getAddress();
		
		return dao.setStudent(name, age, mobile_no, addr, id);
	}

	public List<Student> ajaxSearch(String name) {
		return dao.findByNameStartingWithIgnoreCase(name);
	}

}
