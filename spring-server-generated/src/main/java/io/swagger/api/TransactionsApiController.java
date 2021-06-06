package io.swagger.api;

import io.swagger.model.Transactions;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import io.swagger.service.TransactionService;
import org.threeten.bp.OffsetDateTime;


import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-27T13:17:09.505Z[GMT]")
@RestController
public class TransactionsApiController implements TransactionsApi {

    private static final Logger log = LoggerFactory.getLogger(TransactionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    @Autowired
    private TransactionService transactionService;

    @org.springframework.beans.factory.annotation.Autowired
    public TransactionsApiController(ObjectMapper objectMapper, HttpServletRequest request, TransactionService service) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.transactionService = service;
    }

    public ResponseEntity<Transactions> getTransaction(@Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("ID") Integer ID) {
        String accept = request.getHeader("Accept");

        try {
            if (ID != null) {
                Transactions tran1 = transactionService.getTransactionByID(ID);
                return new ResponseEntity<Transactions>(tran1, HttpStatus.OK);
            }
        } catch (Exception e) {

            return new ResponseEntity<Transactions>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @Override
    public ResponseEntity<List<Transactions>> getTransactions(@DecimalMin("1") @Valid String userID, @DecimalMin("1") @Valid OffsetDateTime startDate, OffsetDateTime endDate) {
        try {
            if (userID != null || startDate != null || endDate != null) {
                return new ResponseEntity<List<Transactions>>(transactionService.getAllTransactionsWithParam(userID, startDate, endDate), HttpStatus.OK);
            }
        }
        catch (Exception e){
            return new ResponseEntity<List<Transactions>>(HttpStatus.BAD_REQUEST);

        }
        return null;
    }


}

