package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getone/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name, @RequestParam Integer age, @RequestParam String sex){
        User user = new User(name,age,sex);
        userService.addUser(user);
        return "success";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
         userService.deleteUser(id);
        return "success";

    }
    @PostMapping("/updateUser")
    public String updateUser(@RequestParam String name, @RequestParam Integer age, @RequestParam String sex,@RequestParam Integer id){
        User user = new User(id,name,age,sex);
        userService.updateUser(user);
        return "success";
    }



}
