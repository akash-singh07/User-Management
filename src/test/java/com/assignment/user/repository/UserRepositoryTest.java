package com.assignment.user.repository;

import com.assignment.user.model.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRepositoryTest {

    @Test
    void findByEmailID() {
    }

    @Test
    void findByUserName() {
    }

    @Test
    void findByMobileNumber() {
    }
}