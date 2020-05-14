package cs544.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import cs544.project.domain.User;
import cs544.project.service.impl.UserServiceImpl;
import cs544.project.service.response.UserResponse;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(method = RequestMethod.GET)
	public List<UserResponse> getUsers() {

		return userService.getAll();
	}

	@PostMapping
	public User saveUser(@RequestBody User user) {
		return userService.create(user);
	}

	@GetMapping(value = "/{id}")
	public UserResponse getUser(@PathVariable Integer id) {
		return userService.getById(id);
	}

	@PostMapping(value = "/update")
	public User updateUser(@RequestBody User user) {
		return userService.update(user);
	}
}
