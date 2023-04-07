package com.ap.serviceImpl;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.ap.binding.User;
import com.ap.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private HashOperations<String, String , User> hashOperations;
	
	public UserServiceImpl(RedisTemplate<String, User> redisTemplate) {
		
		 hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(com.ap.binding.User user) {
		hashOperations.put("USER", user.getId(), user);
	}

	@Override
	public Map<String, com.ap.binding.User> findAll() {
		
		return hashOperations.entries("USER");
	}

	@Override
	public com.ap.binding.User findById(String id) {

		return hashOperations.get("USER", id);
		
		 
	}

	@Override
	public void update(User user) {

		save(user);
	}

	@Override
	public void delete(String id) {
		hashOperations.delete("USER", id);
	}

}
