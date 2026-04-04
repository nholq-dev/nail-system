package com.tkrity.nailsystem.user.controller;

import com.tkrity.nailsystem.user.model.UserRequest;
import com.tkrity.nailsystem.user.model.UserResponse;
import com.tkrity.nailsystem.user.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

   @Resource
   private UserService userService;

   @GetMapping("/{id}")
   public UserResponse getUser(@PathVariable Long id) {
       return userService.getUserById(id);
   }

   @PostMapping
   public UserResponse createUser(@RequestBody UserRequest request){
      return userService.CreateUser(request);
   }
}
