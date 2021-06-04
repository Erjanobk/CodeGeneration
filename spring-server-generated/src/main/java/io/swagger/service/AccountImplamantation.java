package io.swagger.service;

import io.swagger.model.Account;
import io.swagger.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class AccountImplamantation implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void save(Account account) {
        String setiban = ibanFormat();
        account.setIban(setiban);
        accountRepository.save(account);
    }

    @Override
    public Account GetAccountbyName(String name) {
        return (Account) accountRepository.getAccountByName(name);
    }

    @Override
    public String ibanFormat() {
        Random rnd = new Random();
        // String iban = String.format("NL",rnd.nextInt(100),"INHO%07d",rnd.nextInt(1000));
        String iban = "NL" + rnd.nextInt(100) + "INHO" + rnd.nextLong();
        return iban;
    }
}
