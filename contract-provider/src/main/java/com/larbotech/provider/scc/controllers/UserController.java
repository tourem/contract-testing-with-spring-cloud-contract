package com.larbotech.provider.scc.controllers;

import com.larbotech.provider.scc.commands.UserCommand;
import com.larbotech.provider.scc.domains.User;
import com.larbotech.provider.scc.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Map<String,String> createUser(@RequestBody UserCommand userCommand){
        return userService.createUser(userCommand);

    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){

        return userService.getUserById(id);
    }
}
