package io.swagger.api;

import io.swagger.model.CreateTransaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.Transactions;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.model.AccountResult;
import io.swagger.model.User;
import io.swagger.model.Account;
import io.swagger.Service.TransactionService;


import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-27T13:17:09.505Z[GMT]")
@RestController
public class TransactionApiController implements TransactionApi {

    private static final Logger log = LoggerFactory.getLogger(TransactionApiController.class);

    private final ObjectMapper objectMapper;

    private TransactionService transactionService;

    private AccountResult accountResult;

    private Account account;

    private User user;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TransactionApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }


    @Override
    public ResponseEntity<Transactions> createTransaction(@Valid Transactions body) {
        Transactions transaction = new Transactions();
        transaction.setId(Integer.valueOf(body.getId()));
        transaction.setFrom(accountResult.getIBAN());
        transaction.setTo(body.getTo());
        transaction.setAmount(body.getAmount());
        transaction.setMessage(body.getMessage());
        transaction.setUserPerforming(user.getFirstName());
        transaction.setTransactionDate(OffsetDateTime.now());

        double balance = account.getBalance().doubleValue();

        try {
            if (transaction.getAmount() <= transaction.GetDailyLimit() && transaction.getAmount() <= balance){
                transactionService.createTransaction(transaction);
                balance = balance - body.getAmount();
                account.setBalance(BigDecimal.valueOf(balance));
                transaction.SetDailyLimit(body.getAmount());
                return new ResponseEntity<Transactions>(transaction, HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<Transactions>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<Transactions>(transaction, HttpStatus.OK);
    }
}
