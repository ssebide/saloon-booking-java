package com.ssebide.service;

import java.util.List;

import com.ssebide.exception.UserException;
import com.ssebide.modal.User;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id) throws UserException;

    List<User> getAllUsers();

    void deleteUser(Long id) throws UserException;

    User updateUser(Long id, User user) throws UserException;
}
