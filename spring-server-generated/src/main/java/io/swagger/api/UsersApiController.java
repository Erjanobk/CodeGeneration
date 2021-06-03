package io.swagger.api;

import io.swagger.model.Customer;
import io.swagger.model.Update;
import io.swagger.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.UserToCreate;
import io.swagger.service.UserToCreateImpl;
import io.swagger.service.UserToCreateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-27T13:17:09.505Z[GMT]")
@RestController
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    @Autowired
    private UserToCreateImpl userToCreateImpl;
    @Autowired
    private UserToCreateService userToCreateService;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Customer>> getUserAccount(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("userId") Integer userId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Customer>>(objectMapper.readValue("[ {\n  \"DateOfBirth\" : \"1995-06-20T00:00:00.000+00:00\",\n  \"Email\" : \"Joshua@gmail.com\",\n  \"IBAN\" : \"NLxxINHO0xxxxxxxxx\",\n  \"Account_type\" : \"savings\",\n  \"UserId\" : 3,\n  \"CustomerName\" : \"Mr Joshua\"\n}, {\n  \"DateOfBirth\" : \"1995-06-20T00:00:00.000+00:00\",\n  \"Email\" : \"Joshua@gmail.com\",\n  \"IBAN\" : \"NLxxINHO0xxxxxxxxx\",\n  \"Account_type\" : \"savings\",\n  \"UserId\" : 3,\n  \"CustomerName\" : \"Mr Joshua\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Customer>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Customer>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UserToCreate> getUserByID(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("userId") Integer userId) {

        if(userId!=null){
        UserToCreate user =  userToCreateService.getUserByUserId(userId);
        return new ResponseEntity<UserToCreate>(user, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<UserToCreate>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<UserToCreate>> getUsers(@Parameter(in = ParameterIn.QUERY, description = "find user by userName" ,schema=@Schema()) @Valid @RequestParam(value = "userName", required = false) String userName, @Min(0)@Parameter(in = ParameterIn.QUERY, description = "number of records to skip for pagination" ,schema=@Schema(allowableValues={  }
)) @Valid @RequestParam(value = "skip", required = false) Integer skip, @Min(0) @Max(50) @Parameter(in = ParameterIn.QUERY, description = "maximum number of records to return" ,schema=@Schema(allowableValues={  }, maximum="50"
, defaultValue="50")) @Valid @RequestParam(value = "limit", required = false, defaultValue="50") Integer limit) {
        if(userName==null){

            return new ResponseEntity<List<UserToCreate>>(userToCreateImpl.getALLUsers(),HttpStatus.OK);
        }
        else {
            UserToCreate user =  userToCreateImpl.getAllUsersByUserName(userName);
            List<UserToCreate>userToCreates = new ArrayList<>();
            userToCreates.add(user);
            return new ResponseEntity<List<UserToCreate>>(userToCreates,HttpStatus.OK);
        }

    }

    public ResponseEntity<Update> updateUserById(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("userId") Integer userId,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Update>(objectMapper.readValue("{\n  \"Message\" : \"User has been updated\",\n  \"Success\" : true\n}", Update.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Update>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Update>(HttpStatus.NOT_IMPLEMENTED);
    }

}
