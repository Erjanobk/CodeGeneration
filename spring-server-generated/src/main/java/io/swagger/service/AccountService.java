package io.swagger.service;

import io.swagger.model.Account;

public interface AccountService {
    void save(Account account);
    Account GetAccountbyName(String name);
    String ibanFormat();
}
