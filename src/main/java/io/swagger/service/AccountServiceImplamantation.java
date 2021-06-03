package io.swagger.service;

import io.swagger.model.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountServiceImplamantation {
    void save(Account account);
    Account GetAccountbyName(String name);
    String ibanFormat();
}
