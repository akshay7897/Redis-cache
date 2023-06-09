package com.ap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.ap.binding.User;

@SpringBootApplication
public class RedisCatcheApplication {


    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jcf = new JedisConnectionFactory();
        //jcf.setHostName(hostName);
        //jcf.setPassword(password);
        //jcf.setPort(port);
        return jcf;
    }
	
    @Bean
	RedisTemplate<String, User> redisTemplate(){
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(RedisCatcheApplication.class, args);
	}

}
