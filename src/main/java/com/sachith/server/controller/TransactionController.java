package com.sachith.server.controller;

import com.sachith.server.model.Slot;
import com.sachith.server.model.Transaction;
import com.sachith.server.service.SlotService;
import com.sachith.server.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @GetMapping()
    public List<Transaction> readAll() {
        try{
            return transactionService.readAll();
        } catch (Exception ex){
            logger.error("",ex);
            return null;
        }

    }

    @GetMapping("/{status}")
    public List<Transaction> transactionByStatus(@PathVariable String status) {
        try{
            return transactionService.readAll();
        } catch (Exception ex){
            logger.error("",ex);
            return null;
        }

    }

    @GetMapping("/list/{status}")
    public List<Transaction> transactionByStatusForGivenStartDateAndEndDate(@PathVariable String status, @RequestParam(value = "start_date", required = false) String startDate, @RequestParam(value = "end_date", required = false) String endDate) {
        try {
            return transactionService.readAll();
        } catch (Exception ex) {
            logger.error("", ex);
            return null;
        }
    }
}
