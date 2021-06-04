package io.swagger.service;

import io.swagger.model.Account;
import io.swagger.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
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
    public List<Account> GetAccountbyName(String name) {
        return accountRepository.getAllByName(name);
    }

    @Override
    public String ibanFormat() {
        Random rnd = new Random();
        // String iban = String.format("NL",rnd.nextInt(100),"INHO%07d",rnd.nextInt(1000));
        String iban = "NL" + rnd.nextInt(100) + "INHO" + ThreadLocalRandom.current().nextInt();
        while (ibanCheck(iban) == false){
            iban = "NL" + rnd.nextInt(100) + "INHO" + ThreadLocalRandom.current().nextInt();
        }
        return iban;
    }

    @Override
    public boolean ibanCheck(String iban) {
        Account account = accountRepository.getAccountByIban(iban);
        if (account == null){
            return true;
        }
        return false;
    }

    @Override
    public Account getbyIban(String iban) {
        return accountRepository.getAccountByIban(iban);
    }

    @Override
    public int deposit(String iban, int amount) {
            Account account = getbyIban(iban);
            amount = amount + account.getBalance();
            int id = account.getUser();
            return accountRepository.depositAccount(amount,id);
    }

}
