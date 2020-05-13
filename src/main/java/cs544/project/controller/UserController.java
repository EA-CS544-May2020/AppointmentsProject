package cs544.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cs544.project.domain.User;
import cs544.project.service.impl.UserServiceImpl;
//test
// localhost:8081/users
// localhost:8081/users/6
// localhost:8081/users?page=1
// localhost:8081/users?fetch-all=true
// localhost:8081/users/search?query=actor_id:2
// localhost:8081/users/search?query=firstName:PENELOPE
@RestController
@RequestMapping("/users")
public class UserController{
	
	@Autowired
	private UserServiceImpl userService;


	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUsers(){
		
		return userService.getAll();
	}
	
	@PostMapping
	public User saveUser(@RequestBody User user) {
		return userService.create(user);
	}
	
	@GetMapping(value = "/{id}")
	public User getUser(@PathVariable  Integer id) {
		return userService.getById(id);
	}
}
