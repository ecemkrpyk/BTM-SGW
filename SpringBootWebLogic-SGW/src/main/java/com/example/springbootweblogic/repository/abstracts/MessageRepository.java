package com.example.springbootweblogic.repository.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootweblogic.model.Incoming_MessageORC;

public interface MessageRepository extends JpaRepository<Incoming_MessageORC,Integer > {
	
	List<Incoming_MessageORC> findAll();

}
