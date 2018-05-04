package com.example.demo;


import com.example.demo.controller.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(DemoApplication.class, args);

	//	StringRedisTemplate template = context.getBean(StringRedisTemplate.class);


		//CountDownLatch latch = context.getBean(CountDownLatch.class);
	//	LOGGER.info("Sending message....");


	//	template.convertAndSend("chat", "Hello from Redis!");

	//	latch.await();

		//System.exit(0);



	}




//	@Bean
//	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
//					MessageListenerAdapter listenerAdapter){
//			RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//			container.setConnectionFactory(connectionFactory);
//			container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
//
//			return container;
//	}
//
//
//
//	@Bean
//	MessageListenerAdapter listenerAdapter (RedisReceiver redisReceiver){
//		return new MessageListenerAdapter(redisReceiver, "receivermessage");
//
//	}
//
//
//	@Bean
//	RedisReceiver redisReceiver(CountDownLatch latch){
//		return new RedisReceiver(latch);
//	}
//
//
//	@Bean
//	CountDownLatch latch(){
//		return new CountDownLatch(1);
//	}
//
//
//	@Bean
//	StringRedisTemplate template(RedisConnectionFactory connectionFactory){
//		return  new StringRedisTemplate(connectionFactory);
//	}


	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}


	@Bean
	public CommandLineRunner run (RestTemplate restTemplate)throws Exception{


		return rags -> {
			Quote quote = restTemplate.getForObject(
					"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			log.info(quote.toString());
		};

	}

}
