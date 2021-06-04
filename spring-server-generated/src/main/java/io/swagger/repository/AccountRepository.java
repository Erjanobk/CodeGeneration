package io.swagger.repository;

import io.swagger.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
    List<Account> getAllByName(String name);
    Account getAccountByIban(String iban);
    @Transactional
    @Modifying
    @Query("update Account a set balance = ?1 where USER_ID = ?2")
    int depositAccount(int balance, int id);

    @Query("SELECT u from Account where USER_ID = ?1")
    List<Account> getAccountbyuserId(int id);

}
