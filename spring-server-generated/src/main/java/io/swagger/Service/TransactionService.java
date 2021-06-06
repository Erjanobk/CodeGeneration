package io.swagger.service;

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

    private TransactionRepository transactionRepository ;

    public TransactionService(TransactionRepository transRepo) {
        this.transactionRepository = transRepo;
    }

    //Get all transactions from a specific user using a date margin.
    public List<Transactions> getAllTransactionsWithParam(String userId, @DecimalMin("1") @Valid OffsetDateTime startDate, OffsetDateTime endDate) {
        return (List<Transactions>) transactionRepository.getTransactionByParam(userId, startDate, endDate);
    }

    public List<Transactions> getAllTransactions(Integer id, String from, String to, BigDecimal amount, String userPerforming, OffsetDateTime transactionDate) {
        return (List<Transactions>) transactionRepository.getAllTransactions(id, from, to, amount, userPerforming, transactionDate);
    }

    //Using a specific transaction by transactionId
    public Transactions getTransactionByID(Integer id) {
        Transactions transaction = (Transactions) transactionRepository.getTransactionByID((id));
        return transaction;
    }

    //Create a transaction
    public void createTransaction(Transactions transaction) {

        transaction.id(transaction.getId());
        transaction.from((transaction.getFrom()));
        transaction.to(transaction.getTo());
        transaction.amount((transaction.getAmount()));
        transaction.userPerforming(transaction.getUserPerforming());
        transaction.transactionDate(java.time.OffsetDateTime.now());

        transactionRepository.createTransaction(transaction);


    }
}