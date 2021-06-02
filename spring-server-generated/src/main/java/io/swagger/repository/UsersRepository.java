package io.swagger.repository;
import io.swagger.model.UserDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<UserDB,Integer>{
    
}
