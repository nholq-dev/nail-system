package com.tkrity.nailsystem.user.service.impl;


import com.tkrity.nailsystem.exception.BadRequestException;
import com.tkrity.nailsystem.exception.NotFoundException;
import com.tkrity.nailsystem.user.entity.User;
import com.tkrity.nailsystem.user.model.UserRequest;
import com.tkrity.nailsystem.user.model.UserResponse;
import com.tkrity.nailsystem.user.repository.UserRepository;
import com.tkrity.nailsystem.user.service.UserService;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserResponse getUserById(Long id){
        Optional<User> optUser = userRepository.findById(id);

        if(optUser.isPresent()){
            User dataUser = optUser.get();
            return new UserResponse(
                    dataUser.getId(),
                    dataUser.getUserCode(),
                    dataUser.getAddress(),
                    dataUser.getFullName()
            );
        }else{
            throw new NotFoundException("User Not found");
        }

    }

    @Override
    public UserResponse getUserByUserCode(String UserCode) {
        Optional<User> optUser = userRepository.findUserByUserCode(UserCode);
        if(optUser.isPresent()){
            User dataUser = optUser.get();
            return new UserResponse(
                    dataUser.getId(),
                    dataUser.getUserCode(),
                    dataUser.getAddress(),
                    dataUser.getFullName()
            );
        }else{
            throw new NotFoundException("User Not found");
        }
    }

    @Override
    public UserResponse getCurrentUser() {
        return null;
    }

    @Override
    @Transactional
    public UserResponse CreateUser(UserRequest request) {
        User userCreate = new User();
        userCreate.setUserCode(request.getUserCode());
        userCreate.setFirstName(request.getFirstName());
        userCreate.setLastName(request.getLastName());
        userCreate.setAddress(request.getAddress());
        userCreate.setPassword("Password@123");
        UserResponse userExist = getUserByUserCode(userCreate.getUserCode());
        if(userCreate.getUserCode() != null){
            if(Objects.equals(userExist.userCode(), "")) {
                try {
                    userRepository.save(userCreate);
                } catch (Exception ignored) {
                    throw new BadRequestException("Xảy ra lỗi hệ thống");
                }
                System.out.println("done");
                return new UserResponse(
                        userCreate.getId(),
                        userCreate.getUserCode(),
                        userCreate.getAddress(),
                        userCreate.getFullName()
                );
            }else{
                throw new BadRequestException("UserCode đã tồn tại trong hệ thống");
            }
        }else {
            throw new BadRequestException("User Invalid");
        }
    }

}
