package com.example.springbootweblogic.repository.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootweblogic.model.Incoming_MessageORC;
import com.example.springbootweblogic.repository.abstracts.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
    MessageRepository messageRepository;

    public Incoming_MessageORC addMessage(Incoming_MessageORC messageORC) {
        return this.messageRepository.save(messageORC);
    }

    public List<Incoming_MessageORC> getAll() {
        return this.messageRepository.findAll();
    }

}
