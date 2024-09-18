package org.f1soft.graphclient.service;

import org.f1soft.graphclient.entity.Accounts;
import org.f1soft.graphclient.entity.User;
import org.f1soft.graphclient.repository.AccountRepository;
import org.f1soft.graphclient.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private AccountRepository accountRepository;
    public UserService(UserRepository userRepository,AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    //get all users
    public List<User> findAll() {
        return userRepository.findAll();
    }

    //get user by id
    public User findById(String id) {
        Optional<User> issue = userRepository.findById(id);
        return issue.orElse(null);
    }
    //get all user ids string
    public List<String> getAllUserIds(){
        return userRepository.getAllUserId();
    }
    //get account by users
    public List<Accounts> getAccountsByUserId(String userId){
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return accountRepository.findByUser(user);
        }
        return null;
    }
}
