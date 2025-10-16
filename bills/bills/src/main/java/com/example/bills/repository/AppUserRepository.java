package com.example.bills.repository;

import com.example.bills.model.Bill;
import com.example.bills.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);

    @Query("SELECT b FROM Bill b WHERE b IN " +
            "(SELECT b2 FROM Users u2 JOIN u2.bills b2 WHERE u2.id <> :userId) " +
            "AND b IN (SELECT b3 FROM Users u3 JOIN u3.bills b3 WHERE u3.id = :userId)")
    List<Bill> findJointBillsForUser(@Param("userId") Long userId);
}
