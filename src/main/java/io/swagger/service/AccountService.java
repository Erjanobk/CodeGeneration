package io.swagger.service;

import io.swagger.Repository.AccountsRepository;
import io.swagger.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountService implements AccountServiceImplamantation{
    @Autowired
    AccountsRepository accountsRepository;


    @Override
    public void save(Account account) {
        String setiban = ibanFormat();
        account.setIban(setiban);
        accountsRepository.save(account);
    }

    @Override
    public Account GetAccountbyName(String name) {
        return (Account) accountsRepository.getAccountByName(name);
    }

    @Override
    public String ibanFormat() {
        Random rnd = new Random();
       // String iban = String.format("NL",rnd.nextInt(100),"INHO%07d",rnd.nextInt(1000));
        String iban = "NL" + rnd.nextInt(100) + "INHO" + rnd.nextLong();
        return iban;
    }


}
