package io.swagger.service;

import io.swagger.model.Account;

import java.util.List;

public interface AccountService {
    void save(Account account) throws Exception;
    List<Account> GetAccountbyName(String name);
    String ibanFormat();
    boolean ibanCheck(String iban);
    Account getbyIban(String iban);
    int deposit(String iban, int amount) throws Exception;
    Account withdraw(String iban,int amount) throws Exception;
}
