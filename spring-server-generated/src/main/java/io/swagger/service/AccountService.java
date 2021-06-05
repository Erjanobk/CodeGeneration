package io.swagger.service;

import io.swagger.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountService {
    void save(Account account);
    Account GetAccountByName(String name);
    String ibanFormat();
    List<Account> getAllByUser(int userId);
}
