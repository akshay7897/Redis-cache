package com.ap.service;

import java.util.Map;

import com.ap.binding.User;

public interface UserService {

	void save(User user);

	Map<String, User> findAll();

	User findById(String id);

	void update(User user);

	void delete(String id);
}