package emlakcepte.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import emlakcepte.request.UserRequest;



@Component
public class NotificationListener {
	
	@RabbitListener(queues = "emlakcepte.notification")
	public void notificationListener(UserRequest userRequest)
	{
		System.out.println("user :" + userRequest);
	}
	
	@RabbitListener(queues = "emlakcepte.notification.id")
	public void idListener(Integer id)
	{
		System.out.println("Payment successful! User id :" + id);
	}
	
	/*@RabbitListener(queues = "emlakcepte.notification.email")
	public void emailListener(String email)
	{
		System.out.println("email :" + email);
	}*/

}
