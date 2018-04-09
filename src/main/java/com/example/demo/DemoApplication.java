package com.example.demo;

import com.example.demo.redis.RedisReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class DemoApplication {

	//private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

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



}
