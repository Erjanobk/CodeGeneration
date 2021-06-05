package io.swagger.service;

import io.swagger.model.User;
import io.swagger.model.UserToCreate;
import io.swagger.repository.UserRepository;
import io.swagger.repository.UserToCreateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserImplementation  {

    @Autowired
    private UserRepository userRepository;


    public void updateUser(Integer id,User user) {
        User u = getUserById(id);
        u.setEmail(user.getEmail());
        u.setFirstName(user.getFirstName());
        u.setUsername(user.getUsername());
        u.setLastName(user.getLastName());
        u.setUserType(user.getUserType());
    }
    public User getUserById(Integer id){
        return userRepository.getUserByUserId(id);
    }

    //@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
