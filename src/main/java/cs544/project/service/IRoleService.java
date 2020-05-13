package cs544.project.service;

import java.util.List;

import cs544.project.domain.Role;

public interface IRoleService {
	List<Role> getAll();

	Role getById(Integer roleid);

	Role create(Role role);

	Role update(Role role);

	void remove(Integer roleid);
}
