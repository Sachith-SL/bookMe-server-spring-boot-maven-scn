package com.sachith.server.service;

import com.sachith.server.model.Slot;
import com.sachith.server.model.Transaction;

import java.util.List;

public interface TransactionService {

    public Transaction create(Transaction transaction);
    public List<Transaction> readAll() ;
}
