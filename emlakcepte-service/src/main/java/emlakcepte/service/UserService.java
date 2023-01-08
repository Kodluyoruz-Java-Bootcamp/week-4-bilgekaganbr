package emlakcepte.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.client.PackageServiceClient;
import emlakcepte.client.RealtyPackage;
import emlakcepte.configuration.EmlakCepteEmailQueue;
import emlakcepte.configuration.EmlakCepteIdQueue;
import emlakcepte.configuration.RabbitMQConfiguration;
import emlakcepte.controller.UserController;
import emlakcepte.converter.UserConverter;
import emlakcepte.model.User;
import emlakcepte.model.enums.UserStatus;
import emlakcepte.repository.UserRepository;
import emlakcepte.request.LoginRequest;
import emlakcepte.request.PaymentRequest;
import emlakcepte.request.UserRequest;
import emlakcepte.request.UserUpdateRequest;
import emlakcepte.response.UserResponse;



@Service
public class UserService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private RabbitMQConfiguration rabbitMQConfiguration;
	
	@Autowired
	private EmlakCepteEmailQueue emlakcepteEmailQueue;
	
	@Autowired
	private EmlakCepteIdQueue emlakcepteIdQueue;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter converter;
	
	@Autowired
	private PackageServiceClient packageServiceClient;
	
	List<RealtyPackage> packages = new ArrayList<>();
	
	public UserResponse create(UserRequest userRequest)
	{
		User savedUser = userRepository.save(converter.convert(userRequest));
		
		Logger logger = Logger.getLogger(UserController.class.getName());
		logger.log(Level.INFO, "[createUser] - user created: {0}", savedUser.getId());
		
		rabbitTemplate.convertAndSend(rabbitMQConfiguration.getQueueName(), userRequest);
		//rabbitTemplate.convertAndSend(emlakcepteEmailQueue.getQueueName(), userRequest.getEmail());
		
		logger.log(Level.WARNING, "[createUser] - userRequest: {0}, sent to : {1}",
				new Object[] { userRequest.getEmail(), rabbitMQConfiguration.getQueueName() });
		return converter.convert(savedUser);
	}
	
	public UserResponse buy(PaymentRequest paymentRequest)
	{	
		User payingUser = userRepository.findByEmail(paymentRequest.getEmail());
		
		RealtyPackage realtyPackageRequest = new RealtyPackage(payingUser.getId(), LocalDateTime.now(), 
				LocalDateTime.now().plusMonths(1));
		RealtyPackage realtyPackageResponse = packageServiceClient.create(realtyPackageRequest);
		
		
		if (paymentRequest.getAmount() >= realtyPackageRequest.getPrice())
		{
			rabbitTemplate.convertAndSend(emlakcepteIdQueue.getQueueName(), payingUser.getId());
			packages.add(realtyPackageResponse);
			UserResponse payedUser = converter.convert(payingUser);
			payedUser.setRealtyPackageList(packages);
			return converter.convert(payingUser);
		}
		
		else
		{
			return null;
		}
	}
	
	public List<UserResponse> getAll()
	{
		return converter.convert(userRepository.findAll());
	}
	
	public UserResponse getByEmail(String email)
	{
		return converter.convert(userRepository.findByEmail(email));
	}

	public UserResponse getById(Integer userId) {
		
		return converter.convert(userRepository.findById(userId).get());
	}

	public UserResponse update(UserUpdateRequest userUpdateRequest) {
		
		Logger logger = Logger.getLogger(UserController.class.getName());
		
		User updateUser = userRepository.findById(userUpdateRequest.getId()).get();
		
		updateUser.setName(userUpdateRequest.getName());
		updateUser.setEmail(userUpdateRequest.getEmail());
		updateUser.setPassword(userUpdateRequest.getPassword());
		
		User updatedUser = userRepository.save(updateUser);
		
		logger.log(Level.INFO, "[createUser] - user created: {0}", updatedUser.getId());
		
		return converter.convert(updatedUser);
	}
	
	public UserResponse login(LoginRequest loginRequest)
	{	
		Logger logger = Logger.getLogger(UserController.class.getName());
		
		User updateUser = userRepository.findByEmail(loginRequest.getEmail());
		
		if (loginRequest.getPassword().equals(updateUser.getPassword()))
		{	
			updateUser.setStatus(UserStatus.LOGGEDIN);
			User updatedUser = userRepository.save(updateUser);
			
			logger.log(Level.INFO, "Login Success! -> {0}", updatedUser.getEmail());
			
			return converter.convert(updatedUser);
		}
		logger.log(Level.WARNING, "Wrong Password! -> {0}", updateUser.getEmail());
		return null;
	}


}
