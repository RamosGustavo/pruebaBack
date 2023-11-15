package com.example.demo.services;

import com.example.demo.models.Transaction;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        if (transactionRepository.existsById(id)) {
            updatedTransaction.setId(id);
            return transactionRepository.save(updatedTransaction);
        } else {
            // Manejar la lógica de error, por ejemplo, lanzar una excepción
            return null;
        }
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
