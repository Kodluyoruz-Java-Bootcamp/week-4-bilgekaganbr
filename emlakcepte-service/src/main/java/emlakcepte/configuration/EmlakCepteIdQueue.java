package emlakcepte.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmlakCepteIdQueue {
	
	private String queueName = "emlakcepte.notification.id";

	private String exchange = "emlakcepte.notification.id";

	@Bean
	public Queue idQueue() {
		return new Queue(queueName, false);
	}

	@Bean
	public DirectExchange idExchange() {
		return new DirectExchange(exchange);
	}

	@Bean
	public Binding binding(Queue idQueue, DirectExchange idExchange) {
		return BindingBuilder.bind(idQueue).to(idExchange).with("");
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}



}
