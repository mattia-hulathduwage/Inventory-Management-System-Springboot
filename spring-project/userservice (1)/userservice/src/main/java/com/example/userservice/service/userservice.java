package com.example.userservice.service;

import com.example.userservice.data.user;
import com.example.userservice.data.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userservice {

    @Autowired
    private userrepository userrepository;

    public List<user> getUsers() {
        return userrepository.findAll();
    }

    public user getUserById(int id) {
        Optional<user> user = userrepository.findById(id);
        return user.orElse(null);  // Return null if user not found
    }

    public user createUser(user user) {
        return userrepository.save(user);
    }

    public user updateUser(user user) {
        return userrepository.save(user);
    }

    public boolean deleteUser(int id) {
        if (userrepository.existsById(id)) {
            userrepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Method to update the first name by user ID
    public user updateFname(int userid, String newFname) {
        // Find the user by their ID using the injected userRepository instance
        user user = userrepository.findById(userid).orElseThrow(() -> new RuntimeException("User not found"));

        // Update the first name
        user.setFname(newFname);

        // Save the updated user back to the database
        return userrepository.save(user);
    }

    public user updatePassword(int userId, String newPassword) {
        // Trim the password to remove unwanted whitespace, newline characters, and any extra quotes
        newPassword = newPassword.trim();

        // If the password might have quotes, remove them explicitly
        newPassword = newPassword.replace("\"", "");

        // Find the user by ID
        user existingUser = userrepository.findById(userId).orElse(null);

        // Check if user exists
        if (existingUser != null) {
            // Set the new password
            existingUser.setPassword(newPassword);

            // Save the updated user
            return userrepository.save(existingUser);
        } else {
            // Handle user not found case
            return null;
        }
    }


    // New method to find user by email
    public user findByEmail(String email) {
        return userrepository.findByEmail(email);
    }
}
