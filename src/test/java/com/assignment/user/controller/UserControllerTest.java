package com.assignment.user.controller;

import com.assignment.user.exception.ResourceNotFoundException;
import com.assignment.user.model.User;
import com.assignment.user.repository.UserRepository;
import com.assignment.user.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

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
    void getAllUsers() {
        List<User> userList = userService.getAllUsers();
        assertTrue(userList.size() > 0);
    }

    @Test
    @Order(3)
    void getUser() {
        User user = userRepository.findByUserName("akash");
        Long id = user.getUserID();
        User user1 = userService.getUser(id).getBody();
        assertDoesNotThrow(() -> {});
    }

    @Test
    @Order(4)
    void updateUser() throws Exception {
        User user = userRepository.findByUserName("akash");
        Long id = user.getUserID();
        User user1 = new User("akash123", "Akash", "Singh", "0123456789", "akash@gmail.com", "abc", "abc");
        userService.updateUser(id, user1);
        User user2 = userService.getUser(id).getBody();
        assertEquals("akash123", user2.getUserName());
    }

    @Test
    @Order(5)
    void deleteUser() {
        User user = userRepository.findByUserName("akash123");
        Long id = user.getUserID();
        userService.deleteUser(id);
        Exception exception = assertThrows(ResourceNotFoundException.class,() -> {userService.getUser(id);});
        String expectedMessage = "User does not exist";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @Order(6)
    void sortTest() {
        userService.bubbleSort();
    }

}