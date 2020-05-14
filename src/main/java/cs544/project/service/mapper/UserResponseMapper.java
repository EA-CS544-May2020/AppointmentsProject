package cs544.project.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cs544.project.common.utils.BaseMapper;
import cs544.project.domain.User;
import cs544.project.service.response.UserResponse;
import ma.glasnost.orika.MapperFactory;

@Component
public class UserResponseMapper extends BaseMapper<User, UserResponse> {

	@Autowired
	public UserResponseMapper(MapperFactory mapperFactory) {
		super(mapperFactory, User.class, UserResponse.class);
		
	}
}
