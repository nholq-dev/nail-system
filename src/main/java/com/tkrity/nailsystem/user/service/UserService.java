package com.tkrity.nailsystem.user.service;

import com.tkrity.nailsystem.user.model.UserRequest;
import com.tkrity.nailsystem.user.model.UserResponse;

public interface UserService {
    UserResponse getUserById(Long id);

    UserResponse getUserByUserCode(String UserCode);

    UserResponse getCurrentUser();

    UserResponse CreateUser(UserRequest Request);

}
