package io.swagger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;
import io.swagger.repository.TransactionRepository;
import io.swagger.model.Transactions;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.List;


@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository ;

    //Get all transactions from a specific user using a date margin.
    public List<Transactions> getAllTransactionsWithParam(String userId, @DecimalMin("1") @Valid OffsetDateTime startDate, OffsetDateTime endDate) {
        return (List<Transactions>) transactionRepository.getTransactionByParam(userId, startDate, endDate);
    }

    public List<Transactions> getAllTransactions(Integer id, String from, String to, double amount, String message, String userPerforming, OffsetDateTime transactionDate) {
        return (List<Transactions>) transactionRepository.getAllTransactions(id, from, to, amount, message, userPerforming, transactionDate);
    }

    //Using a specific transaction by transactionId
    public Transactions getTransactionByID(Integer id) {
        Transactions transaction = (Transactions) transactionRepository.getTransactionByID((id));
        return transaction;
    }

    //Create a transaction
    public void createTransaction(Transactions transaction) {

        transactionRepository.createTransaction(transaction);

    }
}