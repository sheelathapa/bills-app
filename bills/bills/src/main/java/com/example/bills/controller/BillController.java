package com.example.bills.controller;

import com.example.bills.model.Bill;
import com.example.bills.model.Users;
import com.example.bills.service.BillService;
import com.example.bills.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/bills")
public class BillController {

    private final BillService service;

    private final UserService userService;

    public BillController(BillService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping("/all")
    public String viewBills(Model model) {
        List<Bill> bills = service.getAllBills();
        model.addAttribute("bills", bills);
        model.addAttribute("unpaidCount", service.countUnpaid());
        model.addAttribute("today", LocalDate.now());
        return "index";
    }

    @GetMapping("/add")
    public String addBillForm(Model model) {
        model.addAttribute("bill", new Bill());
        return "add-bill";
    }

    @PostMapping("/save")
    public String saveBill(@ModelAttribute Bill bill) {
        service.save(bill);
        return "redirect:/bills/all";
    }

    @GetMapping("/pay/{id}")
    public String markAsPaid(@PathVariable Long id) {
        service.markAsPaid(id);
        return "redirect:/bills/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBill(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/bills/all";
    }

    @GetMapping("/user/{username}")
    public String viewUserBills(@PathVariable String username, Model model) {
        Users user = userService.getUserByUsername(username);
        model.addAttribute("bills", user.getBills());
        model.addAttribute("username", username);
        model.addAttribute("viewType", "personal");
        return "index";
    }

    @GetMapping("/joint")
    public String viewJointBills(@RequestParam String user1, @RequestParam String user2, Model model) {
        Set<Bill> jointBills = userService.getJointBills(user1, user2);
        model.addAttribute("bills", jointBills);
        model.addAttribute("viewType", "joint");
        model.addAttribute("user1", user1);
        model.addAttribute("user2", user2);
        return "index";
    }

}

