package com.assignment.user;

import com.assignment.user.exception.ResourceNotFoundException;
import com.assignment.user.model.User;
import com.assignment.user.repository.UserRepository;
import com.assignment.user.service.UserService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserManagementApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Test
	@Order(1)
	void createUser() throws Exception {
		User user = new User("akash", "Akash", "Singh", "0123456789", "akash@gmail.com", "abc", "abc");
		userService.createUser(user);
		User user1 = userRepository.findByUserName("akash");
		assertNotNull(user1);
	}

	@Test
	@Order(2)
	void deleteUser() {
		User user = userRepository.findByUserName("akash");
		Long id = user.getUserID();
		userService.deleteUser(id);
		Exception exception = assertThrows(ResourceNotFoundException.class,() -> {userService.getUser(id);});
		String expectedMessage = "User does not exist";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

}
