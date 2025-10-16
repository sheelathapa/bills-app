package com.example.bills.service;

import com.example.bills.model.Bill;
import com.example.bills.repository.BillsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillService {

    private final BillsRepository repo;

    public BillService(BillsRepository repo) {
        this.repo = repo;
    }

    public List<Bill> getAllBills() {
        return repo.findAll();
    }

    public void save(Bill bill) {
        repo.save(bill);
    }

    public void markAsPaid(Long id) {
        repo.findById(id).ifPresent(b -> {
            b.setPaid(true);
            repo.save(b);
        });
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public long countUnpaid() {
        return repo.findByPaidFalse().size();
    }

    public List<Bill> getOverdueBills() {
        return repo.findByDueDateBeforeAndPaidFalse(LocalDate.now());
    }
}

