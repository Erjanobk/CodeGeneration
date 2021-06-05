package io.swagger.service;

import io.swagger.model.Account;
import io.swagger.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Account GetAccountbyName(String name) {
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
    public List<Account> getAllByUser(Integer userId) throws Exception {
        if(userId!=null){
        return accountRepository.getAllByUserid(userId);
        }else{
            throw new Exception("Accounts can not be retrieved");
        }
    }


}
