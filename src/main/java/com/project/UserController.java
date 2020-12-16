package com.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getUser() {
		return userRepository.findAll();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void delete(@RequestBody User user) {
		userRepository.delete(user);
	}
}
