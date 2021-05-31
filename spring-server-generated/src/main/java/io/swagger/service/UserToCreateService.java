package io.swagger.service;

import io.swagger.model.DTO.RegistrationDTO;
import io.swagger.model.UserToCreate;
import org.springframework.stereotype.Service;

@Service
public interface UserToCreateService {
    UserToCreate save(RegistrationDTO registrationDTO);
    boolean cheackMail(RegistrationDTO registrationDTO);
}
