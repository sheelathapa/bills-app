package com.example.bills.service;


import com.example.bills.model.Bill;
import com.example.bills.model.Users;
import com.example.bills.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public Users getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public Set<Bill> getJointBills(String user1Name, String user2Name) {
        Users user1 = userRepo.findByUsername(user1Name);
        Users user2 = userRepo.findByUsername(user2Name);

        if (user1 == null || user2 == null) return Set.of();

        // Intersection of bills (shared bills)
        return user1.getBills().stream()
                .filter(user2.getBills()::contains)
                .collect(Collectors.toSet());
    }
}

