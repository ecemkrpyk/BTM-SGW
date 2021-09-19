package com.example.springbootweblogic.repository.concretes;

import com.example.springbootweblogic.model.UserORC;
import com.example.springbootweblogic.repository.abstracts.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserORC addUser(UserORC userORC) {
        return this.userRepository.save(userORC);
    }

    public List<UserORC> getAll() {
        return this.userRepository.findAll();
    }

    public List<UserORC> getByNameContaining(String name) {
        return this.userRepository.findByNameContaining(name);
    }

}
