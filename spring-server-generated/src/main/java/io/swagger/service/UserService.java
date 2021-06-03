package io.swagger.service;

import io.swagger.api.UsersApiController;
import io.swagger.model.User;
import io.swagger.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    public UserService(){

    }
    public List<User> GetAllUsers(){
        return(List<User>) usersRepository.findAll();
    }
    public User GetUserById(Integer id){
        //need to fix this
        //return usersRepository.findById(id);
        return null;
    }
    public void AddUser(User user){
        usersRepository.save(user);
    }
    public void UpdateUser(User user){
        //usersRepository.
    }
}
