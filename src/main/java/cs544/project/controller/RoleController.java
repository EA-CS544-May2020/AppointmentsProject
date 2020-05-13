package cs544.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import cs544.project.domain.Role;

import cs544.project.service.impl.RoleServiceImpl;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleServiceImpl roleService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Role> getRole() {

		return roleService.getAll();
	}

	@PostMapping
	public Role saveRole(@Valid @RequestBody Role role) {
		return roleService.create(role);
	}

	@GetMapping(value = "/{id}")
	public Role getRole(@PathVariable Integer id) {
		return roleService.getById(id);
	}

	@PostMapping(value = "/update")
	public Role updateRole(@RequestBody Role role) {
		return roleService.update(role);
	}

}
