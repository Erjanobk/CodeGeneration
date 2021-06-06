package io.swagger.service;

import io.swagger.model.DTO.RegistrationDTO;
import io.swagger.model.Result;
import io.swagger.model.User;
import io.swagger.model.UserToCreate;
import io.swagger.model.UserTypeEnum;
import io.swagger.repository.UserToCreateRepository;
import io.swagger.security.JwtTokenProvider;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Log
@Service
public class UserToCreateImpl implements UserToCreateService {
    @Autowired
    private UserToCreateRepository userToCreateRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserToCreate createUser(RegistrationDTO registrationDTO) throws Exception {
        UserToCreate userToCreate=new UserToCreate(registrationDTO.getUserName(),registrationDTO.getPassword(),registrationDTO.getEmail(),registrationDTO.getFirstName(),registrationDTO.getLastName(),registrationDTO.getUsertype());
        UserToCreate registered=null;
        if(cheackMail(registrationDTO)){
            registered=userToCreateRepository.save(userToCreate);
            return registered;
        }
        else{
            throw new Exception("User can not be created");
        }

    }

    @Override
    public boolean cheackMail(RegistrationDTO registrationDTO) {
        UserToCreate emailChecker =userToCreateRepository.getUserToCreateByEmail(registrationDTO.getEmail());
        if(emailChecker==null){
            return true;
        }
        return false;
    }
    public String login(String username,String password){
       // authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        UserToCreate userToCreate = userToCreateRepository.findUserToCreateByUsername(username);
        List<UserTypeEnum>enums=new ArrayList<>();
        enums.add(userToCreate.getUserType());
        return jwtTokenProvider.createToken(username,enums);
    }
    public List<UserToCreate> getALLUsers(){
        return (List<UserToCreate>) userToCreateRepository.findAll();
    }
    public UserToCreate getAllUsersByUserName(String username){
        return (UserToCreate) userToCreateRepository.findUserToCreateByUsername(username);
    }
    public UserToCreate getUserByUserId(Integer userId) throws Exception {
        if(userId!=null){
        UserToCreate user = userToCreateRepository.findUserToCreateByUserId(userId);
        return user;
        }
        else {
            throw new Exception("Users can not be found");
        }

    }
}
