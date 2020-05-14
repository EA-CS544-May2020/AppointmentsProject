package cs544.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.domain.User;
import cs544.project.repository.UserRepository;
import cs544.project.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> getAll() {

		return userRepo.findAll();
	}

	@Override
	public User getById(Integer id) {

		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	@Override
	public User create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public User update(User user) {
		User oldUser = getById(user.getUserid());
		oldUser.setEmail(user.getEmail());
		oldUser.setFirstName(user.getFirstName());
		oldUser.setGender(user.getGender());
		oldUser.setLastName(user.getLastName());
		oldUser.setPassword(passwordEncoder.encode(user.getPassword()));
		oldUser.setRoles(user.getRoles());
		oldUser.setUsername(user.getUsername());
		return userRepo.save(oldUser);
	}

	@Override
	public void remove(Integer id) {
		userRepo.deleteById(id);

	}

}
