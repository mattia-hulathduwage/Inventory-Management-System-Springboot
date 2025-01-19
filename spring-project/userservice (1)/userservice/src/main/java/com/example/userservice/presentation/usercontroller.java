package com.example.userservice.presentation;

import com.example.userservice.data.user;
import com.example.userservice.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class usercontroller {

    @Autowired
    private userservice userservice;

    @GetMapping("/all")
    public List<user> getUsers() {
        return userservice.getUsers();
    }

    @GetMapping("/{id}")
    public user getUserById(@PathVariable("id") int id) {
        return userservice.getUserById(id);
    }

    @PostMapping
    public user createUser(@RequestBody user user) {
        return userservice.createUser(user);
    }

    @PutMapping
    public user updateUser(@RequestBody user user) {
        return userservice.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userservice.deleteUser(id);
    }

    @PutMapping("/updateFname/{userid}")
    public user updateFname(@PathVariable int userid, @RequestParam String fname) {
        return userservice.updateFname(userid, fname);
    }


    @PutMapping("/{id}/password")
    public user updatePassword(@PathVariable("id") int userId, @RequestBody String newPassword) {
        // Call the service method to update the password
        return userservice.updatePassword(userId, newPassword);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody user loginRequest) {
        user existingUser = userservice.findByEmail(loginRequest.getEmail());

        if (existingUser != null && existingUser.getPassword().equals(loginRequest.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid email or password";
        }
    }
}
