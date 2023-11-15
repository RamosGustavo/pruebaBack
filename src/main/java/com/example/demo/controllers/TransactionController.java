package com.example.demo.controllers;

import com.example.demo.models.Transaction;
import com.example.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transacciones")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> obtenerTransacciones() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Optional<Transaction> obtenerTransaccionPorId(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping
    public Transaction crearTransaccion(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @PatchMapping("/{id}")
    public Transaction actualizarTransaccion(@PathVariable Long id, @RequestBody Transaction updatedTransaction) {
        return transactionService.updateTransaction(id, updatedTransaction);
    }

    @DeleteMapping("/{id}")
    public void eliminarTransaccion(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
}
