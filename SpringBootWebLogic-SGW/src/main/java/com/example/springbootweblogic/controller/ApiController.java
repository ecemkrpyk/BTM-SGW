package com.example.springbootweblogic.controller;


import com.example.springbootweblogic.model.Incoming_MessageORC;
import com.example.springbootweblogic.model.UserORC;
import com.example.springbootweblogic.repository.concretes.MessageService;
import com.example.springbootweblogic.repository.concretes.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    @Autowired
    UserService userService;
    
    @Autowired
    MessageService messageService;

    @GetMapping("/isAlive")
    public ResponseEntity<String> IamAlive(){
        return new ResponseEntity<>("Healthy",HttpStatus.OK);
    }
  
    @GetMapping("/users")
    public ResponseEntity<List<UserORC>> getUsers(@RequestParam(required = false) String name) {


        try {
            List<UserORC> users = new ArrayList<>();
            if (name == null) {
                userService.getAll().forEach(users::add);
            } else
                userService.getByNameContaining(name).forEach(users::add);
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    @GetMapping("/messages")
    public ResponseEntity<List<Incoming_MessageORC>> getMessages() {

        try {
            List<Incoming_MessageORC> messages = new ArrayList<>();
       
            messageService.getAll().forEach(messages::add);
      
            if (messages.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(messages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
