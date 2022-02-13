package com.assignment.user.repository;

import com.assignment.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailID(String emailID);

    User findByUserName(String userName);

    User findByMobileNumber(String mobileNumber);
}
