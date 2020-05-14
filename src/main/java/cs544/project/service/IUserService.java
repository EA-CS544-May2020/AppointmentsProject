package cs544.project.service;

import java.util.List;

import cs544.project.domain.User;
import cs544.project.service.response.UserResponse;

public interface IUserService {
	List<UserResponse> getAll();

	UserResponse getById(Integer userid);

	User create(User user);

	User update(User user);

	void remove(Integer userid);
}
