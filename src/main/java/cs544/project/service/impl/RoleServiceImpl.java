package cs544.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.domain.Role;
import cs544.project.repository.RoleRepository;
import cs544.project.service.IRoleService;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private RoleRepository roleRepo;

	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return roleRepo.findAll();
	}

	@Override
	public Role getById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Role> role = roleRepo.findById(id);
		if (role.isPresent()) {
			return role.get();
		} else {
			return null;
		}
	}

	@Override
	public Role create(Role role) {
		// TODO Auto-generated method stub
		return roleRepo.save(role);
	}

	@Override
	public Role update(Role role) {
		// TODO Auto-generated method stub
		Role oldRole = getById(role.getId());
		oldRole.setName(role.getName());
		return roleRepo.save(oldRole);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		roleRepo.deleteById(id);

	}

}
