package com.assignment.user.service;

import com.assignment.user.exception.ResourceNotFoundException;
import com.assignment.user.model.User;
import com.assignment.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) throws Exception {

        if (userRepository.findByEmailID(user.getEmailID()) != null)
            throw new Exception("User with same E-mail already exists.");
        if (userRepository.findByUserName(user.getUserName()) != null)
            throw new Exception("User with same username already exists.");
        if (userRepository.findByMobileNumber(user.getMobileNumber()) != null)
            throw new Exception("User with same mobile number already exists.");

//        List<User> userList = userRepository.findAll();
//        for (User obj: userList) {
//            if (user.getEmailID().equals(obj.getEmailID()))
//                throw new Exception("User with same E-mail already exists.");
//            if (user.getUserName().equals(obj.getUserName()))
//                throw new Exception("User with same username already exists.");
//            if (user.getMobileNumber().equals(obj.getMobileNumber()))
//                throw new Exception("User with same mobile number already exists.");
//        }

        return userRepository.save(user);
    }

    public ResponseEntity<User> getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User does not exist with id " + id));
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<User> updateUser(Long id, User updateUser) throws Exception {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id " + id));
        existingUser.setUserName(updateUser.getUserName());
        existingUser.setFirstName(updateUser.getFirstName());
        existingUser.setLastName(updateUser.getLastName());
        existingUser.setMobileNumber(updateUser.getMobileNumber());
        existingUser.setEmailID(updateUser.getEmailID());
        existingUser.setAddress1(updateUser.getAddress1());
        existingUser.setAddress2(updateUser.getAddress2());

        try {
            userRepository.save(existingUser);
        } catch (Exception e) {
            throw new Exception("Sorry, Updated details could not be saved :(");
        }

        return ResponseEntity.ok(existingUser);
    }

    public ResponseEntity<HttpStatus> deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id " + id));
        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
