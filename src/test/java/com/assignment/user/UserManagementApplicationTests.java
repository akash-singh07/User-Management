package com.assignment.user;

import com.assignment.user.controller.UserController;
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
	private UserController userController;

	@Test
	public void sortTest() {
		userController.bubbleSort();
	}

}
