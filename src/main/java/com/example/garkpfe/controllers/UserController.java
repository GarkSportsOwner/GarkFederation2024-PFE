package com.example.garkpfe.controllers;

import com.example.garkpfe.entities.User;
import com.example.garkpfe.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    @PostMapping("/assign-role-to-user")
    public User assignUser(@RequestParam("userId")Integer userId,
                                 @RequestParam("roleId") Integer roleId){
        return userService.assignUser(userId, roleId);
    }
    @PostMapping("/remove-role-from-user")
    public User desassignUser(@RequestParam("userId")Integer userId,
                                   @RequestParam("roleId") Integer roleId){
        return userService.desassignUser(userId, roleId);
    }
}
