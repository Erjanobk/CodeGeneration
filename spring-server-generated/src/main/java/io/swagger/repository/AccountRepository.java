package io.swagger.repository;
import io.swagger.model.Account;
import io.swagger.model.AccountDB;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
