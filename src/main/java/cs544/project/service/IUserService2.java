package cs544.project.service;

import java.util.List;

import org.hibernate.annotations.Sort;

import cs544.project.domain.User;

public interface IUserService2 {
	List<User> getAll(Sort sort);

	User getById(int id);

	User create(User user);

	User update(User user);

    void remove(int id);
}
