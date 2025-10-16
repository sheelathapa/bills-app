package com.example.bills.controller;


import com.example.bills.model.Bill;
import com.example.bills.model.Users;
import com.example.bills.repository.AppUserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    private final AppUserRepository userRepository;

    public DashboardController(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        String username = principal.getName();
        Users user = userRepository.findByUsername(username).orElseThrow();

        user.getBills().size();
        List<Bill> bills = new ArrayList<>(user.getBills());

        List<Bill> jointBills = userRepository.findJointBillsForUser(user.getId());
        List<Bill> jointBillsList = new ArrayList<>(jointBills);

        model.addAttribute("user", user);
        model.addAttribute("bills", bills);
        model.addAttribute("jointBills", jointBillsList);

        return "dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

