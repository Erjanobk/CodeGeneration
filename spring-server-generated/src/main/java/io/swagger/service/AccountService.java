package io.swagger.service;

import io.swagger.Repository.AccountsRepository;
import io.swagger.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements AccountServiceImplamantation{
    @Autowired
    AccountsRepository accountsRepository;


    @Override
    public void save(Account account) {
        accountsRepository.save(account);
    }

    @Override
    public Account GetAccountbyName(String name) {
        return (Account) accountsRepository.getAccountByName(name);
    }


}
