package com.lcp.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lcp.app.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	List<User> findAllByName(String name);
	List<User> findAllByLastName(String lastname);
}
