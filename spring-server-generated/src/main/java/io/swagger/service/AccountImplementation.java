package io.swagger.service;

import io.swagger.model.Account;
import io.swagger.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AccountImplementation implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void save(Account account) {
        String setiban = ibanFormat();
        account.setIban(setiban);
        accountRepository.save(account);
    }

    @Override
    public Account GetAccountByName(String name) {
        return (Account) accountRepository.getAccountByName(name);
    }

    @Override
    public String ibanFormat() {
        Random rnd = new Random();
        // String iban = String.format("NL",rnd.nextInt(100),"INHO%07d",rnd.nextInt(1000));
        String iban = "NL" + rnd.nextInt(100) + "INHO" + ThreadLocalRandom.current().nextInt();
        return iban;
    }

    @Override
    public List<Account> getAllByUser(int userId) {
        return accountRepository.getAllByUserid(userId);
    }

    public void closeAccount(Account account){
        accountRepository.delete(account);
    }


}
