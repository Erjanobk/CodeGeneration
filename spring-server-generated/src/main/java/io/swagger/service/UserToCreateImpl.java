package io.swagger.service;

import io.swagger.model.DTO.RegistrationDTO;
import io.swagger.model.UserToCreate;
import io.swagger.repository.UserToCreateRepository;
import io.swagger.security.JwtTokenProvider;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public UserToCreate save(RegistrationDTO registrationDTO) {
        UserToCreate userToCreate=new UserToCreate(registrationDTO.getUserName(),registrationDTO.getPassword(),registrationDTO.getEmail(),registrationDTO.getFirstName(),registrationDTO.getLastName(),registrationDTO.getUsertype());
        return userToCreateRepository.save(userToCreate);
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
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        UserToCreate userToCreate = userToCreateRepository.findUserToCreateByUsername(username);
        log.info(userToCreate.getUsername());
        return jwtTokenProvider.createToken(username,userToCreate.getUserTypeEnums());
    }
    public List<UserToCreate> getALLUsers(){
        return (List<UserToCreate>) userToCreateRepository.findAll();
    }
    public UserToCreate getAllUsersByUserName(String username){
        return (UserToCreate) userToCreateRepository.findUserToCreateByUsername(username);
    }
}
