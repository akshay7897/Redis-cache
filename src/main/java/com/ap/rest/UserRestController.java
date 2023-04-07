package com.ap.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ap.binding.User;
import com.ap.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;

	@PostMapping(value = "/user", consumes = "application/json")
	public User add(@RequestBody User user) {
		userService.save(user);
		return userService.findById(user.getId());
	}

	@PutMapping("/user/{id}/{name}")
	public User update(@PathVariable("id") final String id, @PathVariable("name") final String name) {
		userService.update(new User(id, name, 1000L));
		return userService.findById(id);
	}

	@DeleteMapping("/user/{id}")
	public Map<String, User> delete(@PathVariable("id") final String id) {
		userService.delete(id);
		return all();
	}

	@GetMapping("/users")
	public Map<String, User> all() {
		Map<String, User> findAll = userService.findAll();
		return findAll;
		
	}
	
	

}
