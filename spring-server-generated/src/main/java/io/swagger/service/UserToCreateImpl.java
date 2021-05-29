package io.swagger.service;

import io.swagger.model.RegistrationDTO;
import io.swagger.model.UserToCreate;
import io.swagger.repository.UserToCreateRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Log
@Service
public class UserToCreateImpl implements UserToCreateService {
    @Autowired
    private UserToCreateRepository userToCreateRepository;
    @Override
    public UserToCreate save(RegistrationDTO registrationDTO) {
        UserToCreate userToCreate=new UserToCreate(registrationDTO.getUserName(),registrationDTO.getPassword(),registrationDTO.getEmail(),registrationDTO.getFirstName(),registrationDTO.getLastName(),registrationDTO.getUsertype());
        return userToCreateRepository.save(userToCreate);
    }

    @Override
    public boolean cheackMail(RegistrationDTO registrationDTO) {
        String emailChecker =userToCreateRepository.getUserToCreateByEmail(registrationDTO.getEmail());
        if(emailChecker==null){
            return true;
        }
        return false;
    }
}
