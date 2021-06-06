package io.swagger.repository;

import io.swagger.model.Transactions;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.threeten.bp.OffsetDateTime;

import io.swagger.model.Transactions;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transactions, Integer>{
    Transactions getAllTransactions(Integer id, String from, String to, BigDecimal amount, String userPerforming, OffsetDateTime transactionDate);
    Transactions getTransactionByID(Integer transactionID);
    Transactions getTransactionByParam(String userID, OffsetDateTime startDate, OffsetDateTime endDate);
    Transactions createTransaction(Transactions t);
}
