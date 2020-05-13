package cs544.project.service;

import java.util.List;

import cs544.project.domain.User;

public interface IUserService {
	List<User> getAll();

	User getById(Integer userid);

	User create(User user);

	User update(User user);

	void remove(Integer userid);
}
