package emlakcepte.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlakcepte.request.LoginRequest;
import emlakcepte.request.PaymentRequest;
import emlakcepte.request.UserRequest;
import emlakcepte.request.UserUpdateRequest;
import emlakcepte.response.UserResponse;
import emlakcepte.service.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public UserResponse create(@RequestBody UserRequest userRequest)
	{
		Logger logger = Logger.getLogger(UserController.class.getName());
		
		UserResponse userResponse = userService.create(userRequest);
		
		logger.log(Level.INFO, "user created: {0}", userResponse);
		return userResponse;
	}
	
	@GetMapping
	public List<UserResponse> getAll()
	{
		return userService.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public UserResponse getById(@PathVariable Integer id)
	{
		return userService.getById(id);
	}
	
	@GetMapping(value = "/{email}")
	public UserResponse getByEmail(@PathVariable String email)
	{
		return userService.getByEmail(email);
	}
	
	@PutMapping(value = "/update")
	public UserResponse update(@RequestBody UserUpdateRequest userUpdateRequest)
	{
		return userService.update(userUpdateRequest);
	}
	
	@PutMapping(value = "/login")
	public UserResponse login(@RequestBody LoginRequest loginRequest)
	{	
		return userService.login(loginRequest);
		
	}
	
	@PutMapping(value = "/buy")
	public UserResponse buy(@RequestBody PaymentRequest paymentRequest)
	{
		return userService.buy(paymentRequest);
	}

}
