package com.sg.dao;

import java.util.List;
import java.util.Optional;

import com.sg.model.Student;

//similar methods as JpaRepository out-of-the-box methods
public interface IDao {
	public Student deleteById(int id);
	public List<Student> findAll();
	public Student save(Student user);
	Optional<Student> findById(int id);
	public List<Student> findByName(String name);
}
