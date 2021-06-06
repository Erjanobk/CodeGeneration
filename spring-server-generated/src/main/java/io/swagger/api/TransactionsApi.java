/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.25).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Transactions;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-27T13:17:09.505Z[GMT]")
@Validated
public interface TransactionsApi {

    @Operation(summary = "Get a transaction", description = "Get a transaction by ID", security = {
            @SecurityRequirement(name = "bearerAuth")    }, tags={ "Transactions" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retreive the transaction", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Transactions.class)))),

            @ApiResponse(responseCode = "400", description = "Transaction does not exist or wrong transaction ID") })
    @RequestMapping(value = "/transactions/{ID}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Transactions> getTransaction(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("ID") Integer ID);


    @Operation(summary = "Retrieve list of all transactions with optional parameters", description = "", security = {
            @SecurityRequirement(name = "bearerAuth")    }, tags={ "Transactions" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieve Transaction data", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Transactions.class)))) })
    @RequestMapping(value = "/transactions",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Transactions>> getTransactions(@DecimalMin("1")@Parameter(in = ParameterIn.QUERY, description = "Enter the users ID" ,schema=@Schema()) @Valid @RequestParam(value = "UserID", required = false) String userID, @DecimalMin("1")@Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "Start date", required = false) OffsetDateTime startDate, @Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @RequestParam(value = "End date", required = false) org.threeten.bp.OffsetDateTime endDate);

}

