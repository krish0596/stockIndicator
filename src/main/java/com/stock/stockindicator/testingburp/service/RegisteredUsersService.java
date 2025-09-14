package com.stock.stockindicator.testingburp.service;

import com.stock.stockindicator.testingburp.persistence.entity.RegisteredUsersEntity;
import com.stock.stockindicator.testingburp.persistence.RegisteredUsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisteredUsersService {

    private final RegisteredUsersRepository repository;

    public RegisteredUsersService(RegisteredUsersRepository repository) {
        this.repository = repository;
    }

    // Save or update a user
    public RegisteredUsersEntity saveUser(RegisteredUsersEntity user) {
        System.out.println("Saving user: " + user.getName());
        return repository.save(user);
    }

    // Find a user by ID
    public Optional<RegisteredUsersEntity> getUserById(String id) {
        return repository.findById(id);
    }

    // Find a user by email
    public Optional<RegisteredUsersEntity> getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    // Fetch all users
    public List<RegisteredUsersEntity> getAllUsers() {
        return repository.findAll();
    }

    // Optional: delete user by ID
    public void deleteUserById(String id) {
        repository.deleteById(id);
    }
}
