package com.example.application.demo;

import com.example.application.demo.entity.User;
import com.example.application.demo.repo.UserRepository;
import com.example.application.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoApplicationTests {

	@Autowired
	public UserService userService;

	@MockBean
	public UserRepository userRepository;

	@Test
	public void getAllUserTest(){
//		when(userRepository.findAll()).thenReturn(Stream.of(new User(1L,"Akshat","123456"),new User(2L,"Luv","87797845"))
//				.collect(Collectors.toList()));
//		assertEquals(2,userService.getAllUser().size());
	}
}
