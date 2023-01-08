package emlakcepte.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import emlakcepte.model.User;
import emlakcepte.model.enums.UserStatus;
import emlakcepte.request.UserRequest;
import emlakcepte.response.UserResponse;

@Component
public class UserConverter {
	
	public UserResponse convert(User user)
	{
		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setName(user.getName());
		userResponse.setEmail(user.getEmail());
		userResponse.setType(user.getType());
		userResponse.setStatus(user.getStatus());
		return userResponse;
	}
	
	public User convert(UserRequest userRequest)
	{
		User user = new User();
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());
		user.setCreateDate(LocalDateTime.now());
		user.setType(userRequest.getType());
		user.setStatus(UserStatus.LOGGEDOFF);
		return user;
	}
	
	public List<UserResponse> convert(List<User> userList)
	{
		List<UserResponse> userResponses = new ArrayList<>();
		
		userList.stream().forEach(user -> userResponses.add(convert(user)));
		return userResponses;
	}

}
