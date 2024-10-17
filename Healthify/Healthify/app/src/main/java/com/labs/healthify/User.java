package com.labs.healthify;

public class User {
    private String username;
    private String email;
    private String password; // Consider storing a hashed version

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
