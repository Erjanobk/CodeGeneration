package io.swagger.api;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-05T21:01:39.440Z[GMT]")
@Validated
public interface CloseAccountsApi {

    @Operation(summary = "Close account", description = "this will delete the account using the account id", security = {
            @SecurityRequirement(name = "bearerAuth")    }, tags={ "Accounts" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Account has been closed"),

            @ApiResponse(responseCode = "400", description = "Parameters are incorrect"),

            @ApiResponse(responseCode = "404", description = "Id was not found") })
    @RequestMapping(value = "/closeAccounts/{IBAN}",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> accountID(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("IBAN") Integer IBAN);

}
