package com.example.bills.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double amount;
    private LocalDate dueDate;
    private boolean paid;

    @ManyToMany(mappedBy = "bills", fetch = FetchType.EAGER)
    private Set<Users> users;

}
