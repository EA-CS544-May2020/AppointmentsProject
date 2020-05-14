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
import cs544.project.service.mapper.UserResponseMapper;
import cs544.project.service.response.UserResponse;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	UserResponseMapper userResponseMapper;

	@Override
	public List<UserResponse> getAll() {

		List<UserResponse> listUserRes = userResponseMapper.mapCollection(userRepo.findAll());
		return listUserRes;
	}

	@Override
	public UserResponse getById(Integer id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			UserResponse userResponse = userResponseMapper.map(user.get());
			return userResponse;
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
		Optional<User> userDB = userRepo.findById(user.getUserid());
		if (userDB.isPresent()) {
			User oldUser = userDB.get();
			oldUser.setEmail(user.getEmail());
			oldUser.setFirstName(user.getFirstName());
			oldUser.setGender(user.getGender());
			oldUser.setLastName(user.getLastName());
			oldUser.setPassword(passwordEncoder.encode(user.getPassword()));
			oldUser.setRoles(user.getRoles());
			oldUser.setUsername(user.getUsername());
			return userRepo.save(oldUser);
		} else {
			return null;
		}
		
	}

	@Override
	public void remove(Integer id) {
		userRepo.deleteById(id);

	}

}
