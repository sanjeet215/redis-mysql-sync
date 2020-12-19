package com.asiczen.cache.maintenance.config;

import com.asiczen.cache.maintenance.model.OrganizationView;
import com.asiczen.cache.maintenance.model.VehicleInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RedisConfig {

	@Bean
	LettuceConnectionFactory jedisConnectionFactory() {
		return new LettuceConnectionFactory();
	}

	@Bean(name = "vehicleinfo")
	public RedisTemplate<String, VehicleInfo> redisTemplate() {
		RedisTemplate<String, VehicleInfo> template = new RedisTemplate<String, VehicleInfo>();
		template.setConnectionFactory(jedisConnectionFactory());

		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer(objectMapper()));

		return template;
	}


	@Bean(name = "orgparameters")
	public RedisTemplate<String, OrganizationView> redisTemplateOrgParameters() {
		RedisTemplate<String, OrganizationView> template = new RedisTemplate<String, OrganizationView>();
		template.setConnectionFactory(jedisConnectionFactory());

		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer(objectMapper()));

		return template;
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);

		return mapper;
	}
}
