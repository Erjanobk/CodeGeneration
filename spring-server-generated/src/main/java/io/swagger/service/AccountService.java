package io.swagger.service;

import io.swagger.model.Account;
import io.swagger.model.AccountDB;
import io.swagger.model.User;
import io.swagger.repository.AccountRepository;
import io.swagger.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public AccountService(){

    }
    public List<Account> GetAllAccounts(){
        return(List<Account>) accountRepository.findAll();
    }
    public User GetUserById(Integer id){
        //need to fix this
        //return accountRepository.findById(id);
        return null;
    }
    public void OpenAccount(Account account){
        accountRepository.save(account);
    }
    public void UpdateAccount(User user){
        //accountRepository.
    }
    public void CloseAccount(Account account){
        accountRepository.delete(account);
    }
}
