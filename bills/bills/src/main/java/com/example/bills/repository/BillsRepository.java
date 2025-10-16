package com.example.bills.repository;

import com.example.bills.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BillsRepository extends JpaRepository<Bill, Long> {

    List<Bill> findByDueDateBeforeAndPaidFalse(LocalDate date); // Overdue

    List<Bill> findByPaidFalse();


}
