package io.swagger.api;

import io.swagger.model.Account;
import io.swagger.model.Deposit;
import io.swagger.model.DepositResult;
import io.swagger.model.Withdraw;
import io.swagger.model.Withdrawresult;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-27T13:17:09.505Z[GMT]")
@RestController
public class AccountsApiController implements AccountsApi {

    @Autowired
    AccountService accountService;

    private static final Logger log = LoggerFactory.getLogger(AccountsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AccountsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<DepositResult> accountDeposit(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("iban") Integer iban,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Deposit body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<DepositResult>(objectMapper.readValue("{\n  \"success\" : \"Deposit success\",\n  \"CurrentBalance\" : 120,\n  \"time\" : \"02:00 PM\"\n}", DepositResult.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<DepositResult>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<DepositResult>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> accountID(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("IBAN") Integer IBAN) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Withdrawresult> accountWithdrawl(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("iban") Integer iban,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Withdraw body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Withdrawresult>(objectMapper.readValue("{\n  \"remainingbalance\" : 80,\n  \"success\" : \"withdraw success\",\n  \"dailyLimit\" : 80,\n  \"time\" : \"12:00 PM\"\n}", Withdrawresult.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Withdrawresult>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Withdrawresult>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Account> getAccount(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "name", required = true) String name) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Account>(accountService.GetAccountbyName(name),HttpStatus.OK);
    }

    public ResponseEntity<Account> getAccounts(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("IBAN") String IBAN) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Account>(objectMapper.readValue("{\n  \"account_type\" : \"savings\",\n  \"balance\" : 100,\n  \"name\" : \"Mr Joshua\"\n}", Account.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Account>(HttpStatus.NOT_IMPLEMENTED);
    }

}
