package com.sachith.server.service.impl;

import com.sachith.server.model.Transaction;
import com.sachith.server.repository.TransactionRepository;
import com.sachith.server.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction create(Transaction transaction) {
        try {
            return transactionRepository.save(transaction);
        } catch (Exception e){
            logger.error("",e);
            return null;
        }

    }

    @Override
    public List<Transaction> readAll() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> transactionByStatus(String status) {
        return transactionRepository.findByStatus(status);
    }

    @Override
    public List<Transaction> transactionByStatusForGivenStartDateAndEndDate(String status, String startDateString, String endDateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");//2024-08-12
            LocalDate startDate = LocalDate.parse(startDateString, formatter);
            LocalDate endDate = LocalDate.parse(endDateString, formatter);
            return transactionRepository.findByDateBetweenAndStatus(startDate,endDate,status);
        } catch (Exception ex){
            logger.error("",ex);
            return null;
        }
    }
}
