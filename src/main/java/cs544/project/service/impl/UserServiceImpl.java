package cs544.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.domain.User;
import cs544.project.repository.UserRepository;
import cs544.project.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> getAll() {
		
		return userRepo.findAll();
	}

	@Override
	public User getById(Integer id) {
		
		Optional<User> user =  userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			return null;
		}
	}

	@Override
	public User create(User user) {
		return userRepo.save(user);
	}

	@Override
	public User update(User user) {
		//1 get by Id return userIndb
		//2 merge user to userindb
		//3 save userIndb
		return user;
	}

	@Override
	public void remove(Integer id) {
		userRepo.deleteById(id);
		
	}

}
