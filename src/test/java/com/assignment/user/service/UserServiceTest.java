package com.assignment.user.service;

import com.assignment.user.model.User;
import com.assignment.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void getAllUsersTest() {
        when(userRepository.findAll()).thenReturn(Stream.of(new User(1, "akash", "Akash", "Singh", "0123456789", "akash@gmail.com", "abc", "abc")).collect(Collectors.toList()));
        assertEquals(1, userService.getAllUsers().size());
    }

    @Test
    void createUserTest() throws Exception {
        User user = new User(1, "akash", "Akash", "Singh", "0123456789", "akash@gmail.com", "abc", "abc");
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user, userService.createUser(user));
    }

//    @Test
//    void getUserTest() {
//        Long id = new Long(1);
//        User user = new User(1, "akash", "Akash", "Singh", "0123456789", "akash@gmail.com", "abc", "abc");
//        when(userRepository.getById(id)).thenReturn(user);
//        assertEquals(user, userService.getUser(id));
//    }
//
//    @Test
//    void updateUserTest() throws Exception {
//        Long id = new Long(1);
//        User user = new User(1, "akash", "Akash", "Singh", "0123456789", "akash@gmail.com", "abc", "abc");
//        userService.updateUser(id, user);
//        verify(userRepository, times(1)).save(user);
//    }
//
//    @Test
//    void deleteUserTest() {
//        Long id = new Long(1);
//        User user = new User(1, "akash", "Akash", "Singh", "0123456789", "akash@gmail.com", "abc", "abc");
//        userService.deleteUser(id);
//        verify(userRepository, times(1)).delete(user);
//    }

}