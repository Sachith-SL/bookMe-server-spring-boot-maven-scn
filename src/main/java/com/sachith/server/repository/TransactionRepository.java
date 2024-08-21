package com.sachith.server.repository;

import com.sachith.server.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    public List<Transaction> findByStatus(String status);
    public List<Transaction> findByDateBetweenAndStatus(LocalDate startDate, LocalDate endDate, String status);

}
