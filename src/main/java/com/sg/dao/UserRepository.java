package com.sg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsernameAndPassword(String username, String password);
}
