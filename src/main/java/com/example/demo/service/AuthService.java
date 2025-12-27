package com.example.demo.service;

import com.example.demo.model.AppUser;

public interface AuthService {
    AppUser register(AppUser user);
    String authenticate(String email, String password);
}