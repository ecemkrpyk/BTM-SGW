package com.example.springbootweblogic.repository.abstracts;

import com.example.springbootweblogic.model.UserORC;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserORC,Integer > {
    List<UserORC> findAll();

    List<UserORC> findByNameContaining(String name);
    
    
    
}
