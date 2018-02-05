package com.example.redisExample;

import com.example.redisExample.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RedisExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisExampleApplication.class, args);
	}

	//these are templates
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
		jedisConFactory.setHostName("localhost");
		jedisConFactory.setPort(6379);
		return jedisConFactory;
	}
	@Bean
	public RedisTemplate<String, Employee> redisTemplate() {
		RedisTemplate<String, Employee> template = new RedisTemplate<String, Employee>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

}
