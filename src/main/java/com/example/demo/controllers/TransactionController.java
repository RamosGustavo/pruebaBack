package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Transaction;
import com.example.demo.services.TransactionService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        // Validaciones o lógica de negocio antes de guardar la transacción
        Transaction savedTransaction = transactionService.saveTransaction(transaction);

        // Devuelve la respuesta con el código 201 y la ubicación de la nueva transacción
        return ResponseEntity.created(URI.create("/api/transactions/" + savedTransaction.getId())).body(savedTransaction);
    }
}
